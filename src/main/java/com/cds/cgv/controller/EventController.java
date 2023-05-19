package com.cds.cgv.controller;

import com.cds.cgv.common.dto.ApiResponseDTO;
import com.cds.cgv.common.status.SuccessStatus;
import com.cds.cgv.controller.dto.response.EventResponseDTO;
import com.cds.cgv.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping("/events")
    public ApiResponseDTO<List<EventResponseDTO>> getEvents() {
        return ApiResponseDTO.success(SuccessStatus.EVENT_SUCCESS, eventService.getEvents());
    }
}
