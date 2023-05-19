package com.cds.cgv.common.dto;

import com.cds.cgv.common.status.ErrorStatus;
import com.cds.cgv.common.status.SuccessStatus;
import com.cds.cgv.exception.BaseException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponseDTO<T> {
    private final int status;
    private final String message;
    private T data;

    public static <T> ApiResponseDTO<T> success(SuccessStatus successStatus, T data) {
        return new ApiResponseDTO<>(successStatus.getHttpStatus().value(), successStatus.getMessage(), data);
    }

    public static ApiResponseDTO error(ErrorStatus errorStatus) {
        return new ApiResponseDTO(errorStatus.getHttpStatus().value(), errorStatus.getMessage());
    }

    public static ApiResponseDTO error(ErrorStatus errorStatus, String msg) {
        return new ApiResponseDTO<>(errorStatus.getHttpStatus().value(), msg);
    }
}
