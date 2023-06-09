package com.cds.cgv.controller.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class GetMovieRes {
    private Long movieNumber;
    private String title;
    private String originTitle;
    private String posterLink;
    private float reservationRate;
    private float preEgg;
    private float goldenEgg;
    private String director;
    private String actor;
    private String genre;
    private String ageLimit;
    private int duration;
    private String nation;
    private String synopsis;
    private String releasedAt;
    private String closedAt;
    private List<GetTrailerRes> TrailerList;
}
