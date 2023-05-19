package com.cds.cgv.util.mapper;

import com.cds.cgv.controller.dto.response.GetMovieChartRes;
import com.cds.cgv.controller.dto.response.GetMovieRes;
import com.cds.cgv.domain.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    GetMovieRes toGetMovieRes(Movie movie);
    List<GetMovieChartRes> toGetMovieChartResList(List<Movie> movieList);
}