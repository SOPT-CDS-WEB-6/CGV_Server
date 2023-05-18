package com.cds.cgv.controller.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GetTrailerRes {
    private Long trailerNumber;
    private Long movieNumber;
    private String trailerTitle;
    private String thumbnailLink;
    private String trailerReleasedAt;
}
