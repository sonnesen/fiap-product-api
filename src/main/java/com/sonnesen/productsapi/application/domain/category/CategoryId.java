package com.sonnesen.productsapi.application.domain.category;

import java.util.UUID;

public record CategoryId(String value) {

    public CategoryId {
        if (value == null) {
            throw new IllegalArgumentException("Category id cannot be null");
        }
    }

    public static CategoryId generate() {
        return new CategoryId(UUID.randomUUID().toString());
    }

    public static CategoryId from(final String value) {
        try {
            return new CategoryId(UUID.fromString(value).toString());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid category id");
        }
    }

    @Override
    public String toString() {
        return value;
    }

}
