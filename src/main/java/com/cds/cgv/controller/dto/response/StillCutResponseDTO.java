package com.cds.cgv.controller.dto.response;

import com.cds.cgv.domain.StillCutEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class StillCutResponseDTO {
    private final Long stillCutNumber;
    private final Long movieId;
    private final String stillCutLink;

    public static StillCutResponseDTO from(StillCutEntity stillCut) {
        return StillCutResponseDTO.builder()
                .stillCutNumber(stillCut.getStillCutNumber())
                .stillCutLink(stillCut.getStillCutLink())
                .movieId(stillCut.getMovie().getMovieNumber())
                .build();
    }

}
