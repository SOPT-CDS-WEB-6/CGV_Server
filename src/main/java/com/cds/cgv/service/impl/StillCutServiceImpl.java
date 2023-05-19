package com.cds.cgv.service.impl;

import com.cds.cgv.common.status.ErrorStatus;
import com.cds.cgv.controller.dto.response.StillCutResponseDTO;

import com.cds.cgv.exception.BaseException;
import com.cds.cgv.infrastructure.MovieRepository;
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
    private final MovieRepository movieRepository;

    public List<StillCutResponseDTO> findStillCuts(Long movieNumber) {
        movieRepository.findById(movieNumber).orElseThrow(
                        () -> new BaseException(ErrorStatus.INVALID_MOVIE_ID)
        );
        return stillCutRepository.findAllByMovieNumber(movieNumber, PageRequest.of(0, 4)).stream().map(StillCutResponseDTO::from).collect(Collectors.toList());
    }

}
