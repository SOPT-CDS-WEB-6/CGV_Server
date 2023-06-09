package com.cds.cgv.service.impl;

import com.cds.cgv.controller.dto.response.EventResponseDTO;
import com.cds.cgv.domain.EventEntity;
import com.cds.cgv.infrastructure.EventRepository;
import com.cds.cgv.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Transactional(readOnly = true)
    public List<EventResponseDTO> getEvents() {
        return eventRepository.findTop4ByOrderByStartedAtDesc().stream().map(EventResponseDTO::from).collect(Collectors.toList());
    }
}
