package com.sonnesen.productsapi.usecases.category.create;

import java.time.Instant;
import com.sonnesen.productsapi.model.Category;
import com.sonnesen.productsapi.model.CategoryId;

public record CategoryCreateUseCaseOutput(CategoryId id, String name, String description, boolean active,
        Instant createdAt, Instant updatedAt) {

    public static CategoryCreateUseCaseOutput from(final Category category) {
        return new CategoryCreateUseCaseOutput(category.getId(), category.getName(), category.getDescription(),
                category.isActive(), category.getCreatedAt(), category.getUpdatedAt());
    }
}
