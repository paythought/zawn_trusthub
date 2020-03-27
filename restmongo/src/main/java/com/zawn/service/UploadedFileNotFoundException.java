package com.zawn.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UploadedFileNotFoundException extends RuntimeException {
    public UploadedFileNotFoundException(String message) {
        super(message);
    }

    public UploadedFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}