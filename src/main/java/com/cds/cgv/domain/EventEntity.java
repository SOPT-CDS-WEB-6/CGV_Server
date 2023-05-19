package com.cds.cgv.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "event")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventNumber;

    @NotNull
    private String eventTitle;

    @NotNull
    private String eventThumbnailLink;

    @NotNull
    private LocalDate startedAt;

    @NotNull
    private LocalDate endedAt;
}
