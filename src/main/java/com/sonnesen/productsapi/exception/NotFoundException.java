package com.sonnesen.productsapi.exception;

public class NotFoundException extends DomainException {

    public NotFoundException(String message) {
        super(message);
    }

}