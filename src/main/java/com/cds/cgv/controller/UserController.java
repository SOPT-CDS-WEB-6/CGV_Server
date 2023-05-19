package com.cds.cgv.controller;

import com.cds.cgv.common.dto.ApiResponseDTO;
import com.cds.cgv.common.status.SuccessStatus;
import com.cds.cgv.controller.dto.response.GetMovieLogResList;
import com.cds.cgv.controller.dto.response.UserResponseDTO;
import com.cds.cgv.provider.UserProvider;
import com.cds.cgv.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserProvider userProvider;
    private final UserService userService;

    @GetMapping("/{userNumber}/movielog/watched")
    @ResponseStatus(HttpStatus.OK)
    ApiResponseDTO<GetMovieLogResList> getMovieLog(
            @PathVariable Long userNumber,
            @RequestParam int page,
            @RequestParam int size
    ){
        return ApiResponseDTO.success(SuccessStatus.GET_SUCCESS, userProvider.getMovieLog(userNumber, page, size));
    }

    @GetMapping("/{userNumber}")
    ApiResponseDTO<UserResponseDTO> getUserProfile(@PathVariable Long userNumber){
        return ApiResponseDTO.success(SuccessStatus.GET_SUCCESS, userService.getUserProfile(userNumber));
    }
}
