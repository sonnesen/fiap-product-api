package com.sonnesen.productsapi.application.usecases.category.retrieve.get;

import java.time.Instant;

import com.sonnesen.productsapi.application.domain.category.Category;
import com.sonnesen.productsapi.application.domain.category.CategoryId;

public record CategoryGetByIdUseCaseOutput(CategoryId id, String name, String description, boolean isActive,
        Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static CategoryGetByIdUseCaseOutput from(Category category) {
        return new CategoryGetByIdUseCaseOutput(category.getId(), category.getName(), category.getDescription(),
                category.isActive(), category.getCreatedAt(), category.getUpdatedAt(), category.getDeletedAt());
    }
}
