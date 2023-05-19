package com.cds.cgv.service;

import com.cds.cgv.controller.dto.response.StillCutResponseDTO;
import com.cds.cgv.domain.StillCutEntity;

import java.util.List;

public interface StillCutService {
    List<StillCutResponseDTO> findStillCuts(Long movieNumber);
}
