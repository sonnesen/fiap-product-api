package com.sonnesen.productsapi.application.usecases.category.retrieve.list;

import java.time.Instant;

import com.sonnesen.productsapi.application.domain.category.Category;
import com.sonnesen.productsapi.application.domain.category.CategoryId;

public record CategoryListUseCaseOutput(CategoryId id, String name, String description, boolean active,
        Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static CategoryListUseCaseOutput from(final Category category) {
        return new CategoryListUseCaseOutput(category.getId(), category.getName(), category.getDescription(),
                category.isActive(), category.getCreatedAt(), category.getUpdatedAt(), category.getDeletedAt());
    }
}
