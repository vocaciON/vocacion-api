package com.vocaciON.vocacion_service.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException() {
        super();
    }
    public BadRequestException(String message) {
        super(message);
    }


}
