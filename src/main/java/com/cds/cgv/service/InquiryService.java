package com.cds.cgv.service;

import com.cds.cgv.common.status.ErrorStatus;
import com.cds.cgv.controller.dto.request.PostInquiryReq;
import com.cds.cgv.domain.Inquiry;
import com.cds.cgv.domain.InquiryAttachFile;
import com.cds.cgv.exception.BaseException;
import com.cds.cgv.infrastructure.InquiryAttachFileRepository;
import com.cds.cgv.infrastructure.InquiryRepository;
import com.cds.cgv.infrastructure.UserRepository;
import com.cds.cgv.util.mapper.InquiryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InquiryService {
    private final UserRepository userRepository;
    private final InquiryRepository inquiryRepository;
    private final InquiryAttachFileRepository inquiryAttachFileRepository;
    @Transactional
    public Long createInquiry(PostInquiryReq postInquiryReq) {
        // 유효한 유저 id인지 확인
        userRepository.findById(postInquiryReq.getUserNumber())
                .orElseThrow(
                        () -> new BaseException(ErrorStatus.INVALID_USER_ID)
                );

        Inquiry inquirySaved = inquiryRepository.save(InquiryMapper.INSTANCE.toEntity(postInquiryReq));
        return inquirySaved.getInquiryNumber();
    }

    @Transactional
    public void createInquiryAttach(Long inquiryNum, List<String> imagesPathList) {
        // attach_file 등록
        for(String link : imagesPathList) {
            inquiryAttachFileRepository.save(
                    InquiryAttachFile.builder()
                            .inquiry(inquiryRepository.findById(inquiryNum).orElseThrow(
                                    () -> new BaseException(ErrorStatus.DATABASE_ERROR)
                            ))
                            .fileLink(link)
                            .build()
            );
        }
    }
}
