package com.cds.cgv.util.mapper;

import com.cds.cgv.controller.dto.response.GetTrailerRes;
import com.cds.cgv.domain.Trailer;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrailerMapper {
    TrailerMapper INSTANCE = Mappers.getMapper(TrailerMapper.class);

    @Mapping(source = "movie.movieNumber", target = "movieNumber")
    GetTrailerRes ToGetTrailerRes(Trailer trailer);

    @IterableMapping(elementTargetType = GetTrailerRes.class)
    List<GetTrailerRes> ToGetTrailerResList(List<Trailer> trailerList);
}