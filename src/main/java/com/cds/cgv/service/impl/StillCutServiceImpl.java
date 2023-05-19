package com.cds.cgv.service.impl;

import com.cds.cgv.controller.dto.response.StillCutResponseDTO;

import com.cds.cgv.infrastructure.StillCutRepository;
import com.cds.cgv.service.StillCutService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StillCutServiceImpl implements StillCutService {

    private final StillCutRepository stillCutRepository;

    public List<StillCutResponseDTO> findStillCuts(Long movieNumber) {
        return stillCutRepository.findAllByMovieNumber(movieNumber, PageRequest.of(0, 4)).stream().map(StillCutResponseDTO::from).collect(Collectors.toList());
    }

}
