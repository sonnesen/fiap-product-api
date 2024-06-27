package com.sonnesen.productsapi.application.usecases.category.update;

import java.time.Instant;

import com.sonnesen.productsapi.application.domain.category.Category;
import com.sonnesen.productsapi.application.domain.category.CategoryId;

public record CategoryUpdateUseCaseOutput(CategoryId id, String name, String description, boolean isActive,
        Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static CategoryUpdateUseCaseOutput from(final Category category) {
        return new CategoryUpdateUseCaseOutput(category.getId(), category.getName(), category.getDescription(),
                category.isActive(), category.getCreatedAt(), category.getUpdatedAt(), category.getDeletedAt());
    }
}
