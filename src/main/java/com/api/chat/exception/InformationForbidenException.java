package com.api.chat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InformationForbidenException extends RuntimeException{
    public InformationForbidenException(String message) {
        super(message);
    }
}
