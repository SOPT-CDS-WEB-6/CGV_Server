package com.cds.cgv.provider;

import com.cds.cgv.common.status.ErrorStatus;
import com.cds.cgv.controller.dto.response.GetMovieLogRes;
import com.cds.cgv.controller.dto.response.GetMovieLogResList;
import com.cds.cgv.controller.dto.response.PageInfoRes;
import com.cds.cgv.domain.Movie;
import com.cds.cgv.domain.Reservation;
import com.cds.cgv.exception.BaseException;
import com.cds.cgv.infrastructure.MovieRepository;
import com.cds.cgv.infrastructure.ReservationRepository;
import com.cds.cgv.infrastructure.UserRepository;
import com.cds.cgv.util.mapper.ReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProvider {
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final ReservationRepository reservationRepository;

    public GetMovieLogResList getMovieLog(Long userNumber, int page, int size) {
        // 유저 id 유효성 확인
        userRepository.findById(userNumber).orElseThrow(
                () -> new BaseException(ErrorStatus.INVALID_USER_ID)
        );
        // 페이지 가져오기
        Page<Reservation> reservationPage = reservationRepository
                .findAllByUserNumber
                        (PageRequest.of(page-1, size, Sort.by(Sort.Direction.DESC, "startDate")), userNumber);

        // entity to dto 매핑
        List<GetMovieLogRes> getMovieLogResList = ReservationMapper.INSTANCE.toGetMovieLogResList(reservationPage);

        // 영화정보 매핑
        for(GetMovieLogRes getMovieLogRes : getMovieLogResList){
            Movie movie = movieRepository.findById(getMovieLogRes.getMovieNumber())
                    .orElseThrow(
                            () -> new BaseException(ErrorStatus.DATABASE_ERROR)
                    );
            getMovieLogRes.setRestProperties(movie.getTitle(), movie.getOriginTitle(), movie.getPosterLink());
        }
        // response dto로 매핑
        GetMovieLogResList result = new GetMovieLogResList(
                getMovieLogResList,
                new PageInfoRes(page, size, reservationPage.getTotalElements(), reservationPage.getTotalPages()));

        return result;
    }
}
