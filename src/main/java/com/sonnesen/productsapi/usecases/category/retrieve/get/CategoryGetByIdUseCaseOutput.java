package com.sonnesen.productsapi.usecases.category.retrieve.get;

import java.time.Instant;
import com.sonnesen.productsapi.model.Category;
import com.sonnesen.productsapi.model.CategoryId;

public record CategoryGetByIdUseCaseOutput(CategoryId id, String name, String description, boolean isActive,
        Instant createdAt, Instant updatedAt) {

    public static CategoryGetByIdUseCaseOutput from(Category category) {
        return new CategoryGetByIdUseCaseOutput(category.getId(), category.getName(), category.getDescription(),
                category.isActive(), category.getCreatedAt(), category.getUpdatedAt());
    }
}
