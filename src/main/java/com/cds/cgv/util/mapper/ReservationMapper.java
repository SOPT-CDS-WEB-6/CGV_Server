package com.cds.cgv.util.mapper;

import com.cds.cgv.controller.dto.response.MovieLogRes;
import com.cds.cgv.domain.Reservation;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    @Mapping(source = "movie.movieNumber", target = "movieNumber")
    @Mapping(source = "user.userNumber", target = "userNumber")
    MovieLogRes toGetMovieLogRes(Reservation reservation);
    @IterableMapping(elementTargetType = MovieLogRes.class)
    List<MovieLogRes> toGetMovieLogResList(Page<Reservation> reservationList);
}
