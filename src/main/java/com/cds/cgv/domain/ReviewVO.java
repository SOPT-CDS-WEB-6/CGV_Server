package com.cds.cgv.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ReviewVO {
    private Long reviewNumber;
    private String reviewerId;
    private String reviewContent;
    private int likes;
    private LocalDateTime createdAt;
}
