package com.cds.cgv.controller;

import com.cds.cgv.common.dto.ApiResponseDTO;
import com.cds.cgv.common.status.SuccessStatus;
import com.cds.cgv.controller.dto.response.ReviewResponseDTO;
import com.cds.cgv.domain.ReviewResponseWrapper;
import com.cds.cgv.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/movie/{movieId}/review")
    public ApiResponseDTO<Page<ReviewResponseDTO>> getReviews(
            @PathVariable Long movieId,
            @RequestParam int page,
            @RequestParam int size) {
        PageRequest pageRequest = PageRequest.of(--page, size);
        return ApiResponseDTO.success(SuccessStatus.GET_SUCCESS, reviewService.getReviews(movieId, pageRequest));
    }


}
