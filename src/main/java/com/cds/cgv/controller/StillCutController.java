package com.cds.cgv.controller;

import com.cds.cgv.common.dto.ApiResponseDTO;
import com.cds.cgv.common.status.SuccessStatus;
import com.cds.cgv.controller.dto.response.StillCutResponseDTO;
import com.cds.cgv.service.StillCutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StillCutController {

    private final StillCutService stillCutService;

    @GetMapping("/movie/{movieNumber}/stillcuts")
    public ApiResponseDTO<List<StillCutResponseDTO>> getStillCutes(@PathVariable Long movieNumber) {
        return ApiResponseDTO.success(SuccessStatus.GET_SUCCESS, stillCutService.findStillCuts(movieNumber));
    }
}
