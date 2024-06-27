package com.sonnesen.productsapi.application.usecases.category.create;

import java.time.Instant;

import com.sonnesen.productsapi.application.domain.category.Category;
import com.sonnesen.productsapi.application.domain.category.CategoryId;

public record CategoryCreateUseCaseOutput(CategoryId id, String name, String description, boolean active,
        Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static CategoryCreateUseCaseOutput from(final Category category) {
        return new CategoryCreateUseCaseOutput(category.getId(), category.getName(), category.getDescription(),
                category.isActive(), category.getCreatedAt(), category.getUpdatedAt(), category.getDeletedAt());
    }
}
