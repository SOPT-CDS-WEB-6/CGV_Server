package com.cds.cgv.controller.dto.response;


import com.cds.cgv.domain.EventEntity;
import com.cds.cgv.util.DateFormatter;
import lombok.*;

import java.time.LocalDate;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class EventResponseDTO {
    private final int eventNumber;
    private final String eventTitle;
    private final String eventThumbnailLink;
    private final String startedAt;
    private final String endedAt;

    public static EventResponseDTO from(EventEntity event) {
        return EventResponseDTO.builder()
                .eventNumber(event.getEventNumber())
                .eventTitle(event.getEventTitle())
                .eventThumbnailLink(event.getEventThumbnailLink())
                .startedAt(DateFormatter.format(event.getStartedAt()))
                .endedAt(DateFormatter.format(event.getEndedAt()))
                .build();
    }
}
