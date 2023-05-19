package com.cds.cgv.common.advice;

import com.cds.cgv.common.dto.ApiResponseDTO;
import com.cds.cgv.common.status.ErrorStatus;
import com.cds.cgv.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    // Catch Custom Exception(BaseException)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({ BaseException.class })
    protected ApiResponseDTO handleCustomException(BaseException exception) {
        return ApiResponseDTO.error(exception.getStatus());
    }

    // Catch Bad Request Exception
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            MissingServletRequestParameterException.class,
            MissingRequestHeaderException.class,
            IllegalStateException.class,
            IllegalArgumentException.class,
            HttpMessageNotReadableException.class,
            MissingServletRequestParameterException.class,
            MultipartException.class,
            NoHandlerFoundException.class,
    })
    protected ApiResponseDTO handleBadRequestException(Exception exception) {
        logger.debug("Bad request exception occurred: {}",
                exception.getMessage(),
                exception);

        return ApiResponseDTO.error(ErrorStatus.BAD_REQUEST);
    }

    // vallidation
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ApiResponseDTO validException(MethodArgumentNotValidException exception) {
        String msg = "유효성 검사 실패 : " + exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();

        return ApiResponseDTO.error(ErrorStatus.VALIDATION_EXCEPTION, msg);
    }

    // Catch all Exception
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ Exception.class })
    protected ApiResponseDTO handleServerException(Exception exception) {
        logger.error("Unexpected exception occurred: {}",
                exception.getMessage(),
                exception);

        return ApiResponseDTO.error(ErrorStatus.INTERNAL_SERVER_ERROR);
    }
}