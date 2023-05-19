package com.cds.cgv.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PageInfoRes {
    private int page;
    private int size;
    private Long totalElements;
    private int totalPages;
}
