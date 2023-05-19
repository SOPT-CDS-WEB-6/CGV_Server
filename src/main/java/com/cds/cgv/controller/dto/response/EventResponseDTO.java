package com.cds.cgv.controller.dto.response;


import com.cds.cgv.domain.EventEntity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class EventResponseDTO {
    private final int eventNumber;
    private final String eventTitle;
    private final String eventThumbnailLink;
    private final LocalDate startedAt;
    private final LocalDate endedAt;

    public static EventResponseDTO from(EventEntity event) {
        return EventResponseDTO.builder()
                .eventNumber(event.getEventNumber())
                .eventTitle(event.getEventTitle())
                .eventThumbnailLink(event.getEventThumbnailLink())
                .startedAt(event.getStartedAt())
                .endedAt(event.getEndedAt())
                .build();
    }
}
