package com.cds.cgv.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "trailer")
@Getter
@Setter
public class Trailer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Long trailerNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_number")
    private Movie movie;
    private String trailerTitle;
    @Column(columnDefinition = "TEXT")
    private String thumbnailLink;
    @Column(columnDefinition = "date")
    private String trailerReleasedAt;
}
