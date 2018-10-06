package com.hardnets.gescolar.exception;

import com.hardnets.gescolar.domain.ErrorCode;

public class ResourceNotFoundException extends ServiceException {
    public ResourceNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
