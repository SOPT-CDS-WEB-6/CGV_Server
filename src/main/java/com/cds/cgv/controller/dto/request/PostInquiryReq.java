package com.cds.cgv.controller.dto.request;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class PostInquiryReq {
    public PostInquiryReq(int userId, String type, boolean isTheaterSelected, String domestic, String region, String cinemaName, String title, String content) {
        this.userId = userId;
        this.type = type;
        this.isTheaterSelected = isTheaterSelected;
        this.domestic = domestic;
        this.region = region;
        this.cinemaName = cinemaName;
        this.title = title;
        this.content = content;
    }
    public PostInquiryReq(int userId, String type, boolean isTheaterSelected, String title, String content) {
        this.userId = userId;
        this.type = type;
        this.isTheaterSelected = isTheaterSelected;
        this.title = title;
        this.content = content;
    }
    private int userId;
    private String type;
    private boolean isTheaterSelected;
    private String domestic;
    private String region;
    private String cinemaName;
    private String title;
    private String content;
}
