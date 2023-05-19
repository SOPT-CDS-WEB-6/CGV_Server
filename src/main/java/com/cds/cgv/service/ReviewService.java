package com.cds.cgv.service;

import com.cds.cgv.controller.dto.response.ReviewResponseDTO;
import com.cds.cgv.domain.ReviewResponseWrapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewService {
    Page<ReviewResponseDTO> getReviews(Long movieId, Pageable pageable);
}
