package com.cds.cgv.controller.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GetMovieChartRes {
    private Long movieNumber;
    private String title;
    private String posterLink;
    private float reservationRate;
    private float goldenEgg;
}
