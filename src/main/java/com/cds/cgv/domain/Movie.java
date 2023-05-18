package com.cds.cgv.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "movie")
// TODO : 지우셈
@Getter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Integer movieNumber;
    private String title;
    private String originTitle;
    @Column(columnDefinition = "TEXT")
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
    @Column(columnDefinition = "Date")
    private String releasedAt;
    @Column(columnDefinition = "Date")
    private String closedAt;
}
