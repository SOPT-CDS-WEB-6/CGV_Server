package com.cds.cgv.controller;

import com.cds.cgv.service.SupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/support")
public class SupportController {
    private final SupportService supportService;

    @PostMapping("/inquiry")


}
