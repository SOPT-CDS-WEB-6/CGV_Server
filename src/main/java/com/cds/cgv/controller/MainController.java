package com.cds.cgv.controller;

import com.cds.cgv.common.dto.ApiResponseDTO;
import com.cds.cgv.common.status.SuccessStatus;
import com.cds.cgv.controller.dto.response.GetMovieChartRes;
import com.cds.cgv.provider.MovieProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {
    private final MovieProvider movieProvider;

    @GetMapping("/moviechart")
    ApiResponseDTO<List<GetMovieChartRes>> getMovieChart(){
        return ApiResponseDTO.success(SuccessStatus.GET_SUCCESS, movieProvider.getMovieChart());
    }
}
