package com.cds.cgv.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class PostInquiryReq {
    @NotNull(message = "userNumber은 null일 수 없습니다.")
    private Long userNumber;
    @NotBlank(message = "type은 blank일 수 없습니다.")
    private String type;
    @NotNull(message = "isTheaterSelected는 null일 수 없습니다.")
    private boolean isTheaterSelected;
    private String domestic;
    private String region;
    private String cinemaName;
    @NotBlank(message = "title은 blank일 수 없습니다.")
    private String title;
    @NotBlank(message = "content는 blank일 수 없습니다.")
    private String content;
}
