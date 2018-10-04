package com.hardnets.gescolar.domain;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
public enum ErrorCode {

    FamiliaresEntity_NOT_FOUND(NOT_FOUND, "FamiliaresEntity not found", "person-not-found"),
    INVALID_RUT(BAD_REQUEST, "Invalid rut", "invalid-rut");

    private HttpStatus httpStatus;
    private String message;
    private String messageKey;

    ErrorCode(HttpStatus httpStatus, String message, String messageKey) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.messageKey = messageKey;
    }
}
