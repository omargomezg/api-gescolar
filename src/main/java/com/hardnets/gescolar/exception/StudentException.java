package com.hardnets.gescolar.exception;

import com.hardnets.gescolar.domain.ErrorCode;
import lombok.Getter;

@Getter
public class StudentException extends ServiceException {    
    public StudentException(ErrorCode errorCode){
        super(errorCode);
    }
}
