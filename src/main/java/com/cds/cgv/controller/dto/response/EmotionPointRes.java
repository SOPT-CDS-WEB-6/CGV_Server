package com.cds.cgv.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmotionPointRes {
    private float stress_relief;
    private float pleasure;
    private float tension;
    private float immersion;
    private float moving;
}


