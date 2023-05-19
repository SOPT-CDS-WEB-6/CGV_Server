package com.cds.cgv.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reservation")
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Long reservationNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_number", columnDefinition = "INT UNSIGNED")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_number", columnDefinition = "INT UNSIGNED")
    private Movie movie;
    @Column(columnDefinition = "Timestamp")
    private Timestamp startDate;
    @Column(columnDefinition = "Timestamp")
    private Timestamp endDate;
    private String theaterName;
    private int headcount;
    @Column(columnDefinition = "Tinyint")
    private boolean isReviewed;
    @Column(columnDefinition = "Timestamp")
    private Timestamp reservatedAt;
}
