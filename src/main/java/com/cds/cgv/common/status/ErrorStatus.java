package com.cds.cgv.common.status;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorStatus {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 에러"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청 입니다. 요청 값을 확인하세요."),
    DATABASE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "데이터베이스 에러"),
    VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "요청 필드의 제약조건을 확인하세요."),
    INVALID_ID(HttpStatus.BAD_REQUEST, "잘못된 id 정보 입니다."),
    INVALID_USER_ID(HttpStatus.BAD_REQUEST, "잘못된 유저 id 정보 입니다."),
    INVALID_FILE_TYPE(HttpStatus.BAD_REQUEST, "fileType 값을 확인하세요."),

    ;

    private final HttpStatus httpStatus;
    private final String message;
}
