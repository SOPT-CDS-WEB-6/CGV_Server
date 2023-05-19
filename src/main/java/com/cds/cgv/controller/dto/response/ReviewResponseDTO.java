package com.cds.cgv.controller.dto.response;


import com.cds.cgv.domain.ReviewEntity;
import com.cds.cgv.domain.ReviewResponseWrapper;
import com.cds.cgv.domain.ReviewVO;
import com.cds.cgv.util.DateFormatter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewResponseDTO {
    private final Long reviewNumber;
    private final String reviewerId;
    private final String reviewContent;
    private final Integer likes;
    private final String createdAt;

    public static ReviewResponseDTO from(ReviewResponseWrapper review){
        return ReviewResponseDTO.builder()
                .reviewNumber(review.getReviewNumber())
                .reviewContent(review.getReviewContent())
                .createdAt(DateFormatter.format(review.getCreatedAt()))
                .likes(review.getLikes())
                .reviewerId(review.getReviewerId())
                .build();
    }

}
