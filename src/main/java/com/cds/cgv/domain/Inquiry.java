package com.cds.cgv.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "inquiry")
@Getter
@Setter
@DynamicInsert
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Long inquiryNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userNumber")
    private User user;
    private String type;
    private boolean isTheaterSelected;
    private String domestic;
    private String region;
    private String cinemaName;
    private String title;
    private String content;
}
