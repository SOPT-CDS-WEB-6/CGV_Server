package com.cds.cgv.provider;

import com.cds.cgv.common.status.ErrorStatus;
import com.cds.cgv.controller.dto.response.GetMovieLogRes;
import com.cds.cgv.domain.Movie;
import com.cds.cgv.domain.Reservation;
import com.cds.cgv.exception.BaseException;
import com.cds.cgv.infrastructure.MovieRepository;
import com.cds.cgv.infrastructure.ReservationRepository;
import com.cds.cgv.infrastructure.UserRepository;
import com.cds.cgv.util.mapper.ReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProvider {
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final ReservationRepository reservationRepository;

    public List<GetMovieLogRes> getMovieLog(Long userNumber) {
        // 유저 id 유효성 확인
        userRepository.findById(userNumber).orElseThrow(
                () -> new BaseException(ErrorStatus.INVALID_USER_ID)
        );
        List<Reservation> reservationList = reservationRepository.findAllByUserId(userNumber);

        // entity to dto 매핑
        List<GetMovieLogRes> getMovieLogResList = ReservationMapper.INSTANCE.toGetMovieLogResList(reservationList);

        // 영화정보 매핑
        // TODO : 영화 정보가 있다면 매핑? 오류 안나나
        // TODO : 페이지네이션
        for(GetMovieLogRes getMovieLogRes : getMovieLogResList){
            Movie movie = movieRepository.findById(getMovieLogRes.getMovieNumber())
                    .orElseThrow(
                            () -> new BaseException(ErrorStatus.DATABASE_ERROR)
                    );
            getMovieLogRes.setRestProperties(getMovieLogRes.getTitle(), getMovieLogRes.getOriginTitle(), getMovieLogRes.getPosterLink());
        }

        return getMovieLogResList;
    }
}
