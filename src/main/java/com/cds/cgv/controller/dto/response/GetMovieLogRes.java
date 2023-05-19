package com.cds.cgv.controller.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetMovieLogRes {
    public void setRestProperties(String title, String originTitle, String posterLink){
        this.title = title;
        this.originTitle = originTitle;
        this.posterLink = posterLink;
    }

    private Long userNumber;
    private Long movieNumber;
    private String title;
    private String originTitle;
    private String posterLink;
    private String startDate;
    private String endDate;
    private String theaterName;
    private int headcount;
    private boolean isReviewed;
    private String reservatedAt;
}
