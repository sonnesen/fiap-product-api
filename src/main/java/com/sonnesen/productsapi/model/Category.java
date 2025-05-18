package com.sonnesen.productsapi.model;

import java.time.Instant;
import lombok.Getter;

@Getter
public class Category {

    private CategoryId id;
    private String name;
    private String description;
    private boolean active;
    private Instant createdAt;
    private Instant updatedAt;

    private Category(final CategoryId id, final String name, final String description, final boolean active,
            final Instant createdAt, final Instant updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Category newCategory(final String name, final String description) {
        final var now = Instant.now();
        final var active = true;
        return new Category(CategoryId.unique(), name, description, active, now, now);
    }

    public static Category with(final CategoryId id, final String name, final String description,
            final boolean isActive, final Instant createdAt, final Instant updatedAt) {
        return new Category(id, name, description, isActive, createdAt, updatedAt);
    }

    public Category update(final String name, final String description, final boolean active) {
        if (active) {
            activate();
        } else {
            deactivate();
        }
        this.name = name;
        this.description = description;
        this.updatedAt = Instant.now();
        return this;
    }

    public Category activate() {
        this.active = true;
        return this;
    }

    public Category deactivate() {
        this.active = false;
        return this;
    }
}
