package com.cds.cgv.controller;

import com.cds.cgv.common.dto.ApiResponseDTO;
import com.cds.cgv.common.status.SuccessStatus;
import com.cds.cgv.controller.dto.request.PostInquiryReq;
import com.cds.cgv.controller.dto.response.PostInquiryRes;
import com.cds.cgv.service.FileService;
import com.cds.cgv.service.InquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/support")
public class SupportController {
    private final InquiryService inquiryService;
    private final FileService fileService;

    @Transactional
    @PostMapping(value = "/inquiry", consumes = "multipart/form-data")
    @ResponseStatus(HttpStatus.CREATED)
    ApiResponseDTO<PostInquiryRes> createInquiry(
            @RequestPart("data") @Valid PostInquiryReq postInquiryReq,
            @RequestPart("file") MultipartFile[] multipartFileList
    ) throws Exception {
        // 문의 등록
        Long createdInquiryNum = inquiryService.createInquiry(postInquiryReq);

        // 문의 파일 등록
        inquiryService.createInquiryAttach(createdInquiryNum, fileService.uploadFiles(multipartFileList, "inquiry-attach-file"));

        return ApiResponseDTO.success(SuccessStatus.POST_SUCCESS, new PostInquiryRes(createdInquiryNum));
    }

}
