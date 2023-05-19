package com.cds.cgv.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetMovieLogResList {
    private List<GetMovieLogRes> page;
    private PageInfoRes pageInfoRes;
}
