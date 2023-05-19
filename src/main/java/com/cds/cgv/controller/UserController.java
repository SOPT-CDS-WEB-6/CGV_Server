package com.cds.cgv.controller;

import com.cds.cgv.common.dto.ApiResponseDTO;
import com.cds.cgv.common.status.SuccessStatus;
import com.cds.cgv.controller.dto.response.GetMovieLogRes;
import com.cds.cgv.provider.UserProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserProvider userProvider;

    @GetMapping("/{userId}/movielog/watched")
    ApiResponseDTO<List<GetMovieLogRes>> getMovieLog(
            @PathVariable Long userNumber
    ){
        return ApiResponseDTO.success(SuccessStatus.GET_SUCCESS, userProvider.getMovieLog(userNumber));
    }
}
