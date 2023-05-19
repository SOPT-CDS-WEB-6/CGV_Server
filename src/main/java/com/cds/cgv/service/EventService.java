package com.cds.cgv.service;

import com.cds.cgv.controller.dto.response.EventResponseDTO;

import java.util.List;

public interface EventService {
    List<EventResponseDTO> getEvents();
}
