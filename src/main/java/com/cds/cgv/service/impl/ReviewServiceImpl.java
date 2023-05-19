package com.cds.cgv.service.impl;

import com.cds.cgv.controller.dto.response.ReviewResponseDTO;
import com.cds.cgv.domain.ReviewEntity;
import com.cds.cgv.domain.ReviewResponseWrapper;
import com.cds.cgv.infrastructure.ReviewRepository;
import com.cds.cgv.service.ReviewService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor()
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public Page<ReviewResponseWrapper> getReviews(Long movieId, Pageable pageable) {
        return reviewRepository.findByMovieId(movieId, pageable);
    }
}
