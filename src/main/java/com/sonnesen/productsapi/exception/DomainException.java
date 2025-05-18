package com.sonnesen.productsapi.exception;

public class DomainException extends RuntimeException {

    public DomainException(String message) {
        this(message, null);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause, true, false);
    }

}
