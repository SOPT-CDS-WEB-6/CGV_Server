package com.cds.cgv.controller;

import com.cds.cgv.common.dto.ApiResponseDTO;
import com.cds.cgv.common.status.SuccessStatus;
import com.cds.cgv.controller.dto.response.GetMovieRes;
import com.cds.cgv.controller.dto.response.GetReviewPointStatRes;
import com.cds.cgv.provider.MovieProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieProvider movieProvider;

    /**
     * 단일 영화 정보 가져오기
     * @param movieNumber
     * @return
     */
    @GetMapping("/{movieNumber}")
    @ResponseStatus(HttpStatus.OK)
    ApiResponseDTO<GetMovieRes> getMovie(
            @PathVariable Long movieNumber
    ){
        return ApiResponseDTO.success(SuccessStatus.GET_SUCCESS, movieProvider.getMovie(movieNumber));
    }

    /**
     * 영화 리뷰 포인트 통계 가져오기
     * @param movieNumber
     * @return
     */
    @GetMapping("/{movieNumber}/review-statistics/score")
    @ResponseStatus(HttpStatus.OK)
    ApiResponseDTO<GetReviewPointStatRes> getReviewPointStat(
            @PathVariable Long movieNumber
    ){
        return ApiResponseDTO.success(SuccessStatus.GET_SUCCESS, movieProvider.getReviewPointStat(movieNumber));
    }
}
