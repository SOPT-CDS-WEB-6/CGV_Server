package com.cds.cgv.util.mapper;

import com.cds.cgv.controller.dto.response.GetMovieLogRes;
import com.cds.cgv.domain.Reservation;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    @Mapping(source = "movie.movieNumber", target = "movieNumber")
    @Mapping(source = "user.userNumber", target = "userNumber")
    GetMovieLogRes toGetMovieLogRes(Reservation reservation);
    @IterableMapping(elementTargetType = GetMovieLogRes.class)
    List<GetMovieLogRes> toGetMovieLogResList(List<Reservation> reservationList);
}
