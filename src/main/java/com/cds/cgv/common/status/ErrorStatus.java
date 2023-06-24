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
    INVALID_MOVIE_ID(HttpStatus.BAD_REQUEST, "잘못된 영화 id 정보 입니다."),
    INVALID_FILE_TYPE(HttpStatus.BAD_REQUEST, "fileType 값을 확인하세요."),
    INVALID_INQUIRY_TYPE(HttpStatus.BAD_REQUEST, "문의 유형(type) 값을 확인하세요."),

    NOT_FOUND_SAVE_IMAGE_EXCEPTION(HttpStatus.BAD_REQUEST, "이미지 저장에 실패했습니다"),
    NOT_FOUND_FILE_EXCEPTION(HttpStatus.NOT_FOUND, "존재하지 않는 파일입니다"),
    NOT_FOUND_IMAGE_EXCEPTION(HttpStatus.NOT_FOUND, "이미지 이름을 찾을 수 없습니다"),
    INVALID_MULTIPART_EXTENSION_EXCEPTION(HttpStatus.BAD_REQUEST, "허용되지 않은 타입의 파일입니다")

    ;

    private final HttpStatus httpStatus;
    private final String message;
}
