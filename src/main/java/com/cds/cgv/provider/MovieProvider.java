package com.cds.cgv.provider;

import com.cds.cgv.common.status.ErrorStatus;
import com.cds.cgv.controller.dto.response.GetMovieChartRes;
import com.cds.cgv.controller.dto.response.GetMovieRes;
import com.cds.cgv.domain.Movie;
import com.cds.cgv.domain.Trailer;
import com.cds.cgv.exception.BaseException;
import com.cds.cgv.infrastructure.MovieRepository;
import com.cds.cgv.infrastructure.TrailerRepository;
import com.cds.cgv.util.mapper.MovieMapper;
import com.cds.cgv.util.mapper.TrailerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieProvider {
    private final MovieRepository movieRepository;
    private final TrailerRepository trailerRepository;
    public GetMovieRes getMovie(Long movieNumber) {
        Movie movie = movieRepository.findById(movieNumber)
                .orElseThrow(() -> new BaseException(ErrorStatus.INVALID_ID));
        List<Trailer> trailerList = trailerRepository.findAllByMovieNumber(movieNumber);

        // mapping
        GetMovieRes getMovieRes = MovieMapper.INSTANCE.toGetMovieRes(movie);
        getMovieRes.setTrailerList(TrailerMapper.INSTANCE.ToGetTrailerResList(trailerList));

        return getMovieRes;
    }

    public List<GetMovieChartRes> getMovieChart() {
        List<Movie> movieList = movieRepository
                .findMoviesOrderByReservationRate(
                        PageRequest.of(0, 4, Sort.by(Sort.Direction.DESC, "reservationRate")));

        return MovieMapper.INSTANCE.toGetMovieChartResList(movieList);
    }
}
