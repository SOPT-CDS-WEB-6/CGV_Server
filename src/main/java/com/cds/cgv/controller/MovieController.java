package com.cds.cgv.controller;

import com.cds.cgv.common.dto.ApiResponseDTO;
import com.cds.cgv.common.status.SuccessStatus;
import com.cds.cgv.controller.dto.response.GetMovieRes;
import com.cds.cgv.provider.MovieProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    ApiResponseDTO<GetMovieRes> getMovie(
            @PathVariable Long movieNumber
    ){
        return ApiResponseDTO.success(SuccessStatus.GET_SUCCESS, movieProvider.getMovie(movieNumber));
    }
}
