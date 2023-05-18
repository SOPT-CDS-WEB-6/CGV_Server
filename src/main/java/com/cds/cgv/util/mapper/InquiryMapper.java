package com.cds.cgv.util.mapper;

import com.cds.cgv.controller.dto.request.PostInquiryReq;
import com.cds.cgv.domain.Inquiry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InquiryMapper {
    InquiryMapper INSTANCE = Mappers.getMapper(InquiryMapper.class);
    @Mapping(target = "user.userNumber", source = "userNumber")
    Inquiry toEntity(PostInquiryReq postInquiryReq);
}
