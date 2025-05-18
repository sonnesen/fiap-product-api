package com.sonnesen.productsapi.model;

import java.util.Objects;
import java.util.UUID;

public class CategoryId {
    private final String value;

    private CategoryId(final String value) {
        this.value = Objects.requireNonNull(value);
    }

    public static CategoryId unique() {
        return new CategoryId(UUID.randomUUID().toString());
    }

    public static CategoryId from(final String value) {
        try {
            return new CategoryId(UUID.fromString(value).toString());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid category id");
        }
    }

    public String getValue() {
        return value;
    }

}
