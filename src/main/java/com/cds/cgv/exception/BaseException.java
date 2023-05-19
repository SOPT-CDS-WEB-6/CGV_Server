package com.cds.cgv.exception;

import com.cds.cgv.common.status.ErrorStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// unchecked exception을 위해 RuntimeException을 상속받음
@Getter
@Setter
@AllArgsConstructor
public class BaseException extends RuntimeException {
    private ErrorStatus status;
}
