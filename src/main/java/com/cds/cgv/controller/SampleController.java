package com.cds.cgv.controller;

import com.cds.cgv.common.status.SuccessStatus;
import com.cds.cgv.controller.dto.ApiResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/sample")
    public ApiResponseDTO success() {
        return ApiResponseDTO.success(SuccessStatus.EVENT_SUCCESS, "DATA");
    }
}
