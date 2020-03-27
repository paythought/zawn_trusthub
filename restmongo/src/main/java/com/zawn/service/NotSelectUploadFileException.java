package com.zawn.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotSelectUploadFileException extends RuntimeException {
    public NotSelectUploadFileException(String message) {
        super(message);
    }

    public NotSelectUploadFileException(String message, Throwable cause) {
        super(message, cause);
    }
}