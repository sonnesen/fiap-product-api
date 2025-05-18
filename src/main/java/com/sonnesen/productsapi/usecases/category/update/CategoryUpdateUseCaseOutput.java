package com.sonnesen.productsapi.usecases.category.update;

import java.time.Instant;
import com.sonnesen.productsapi.model.Category;
import com.sonnesen.productsapi.model.CategoryId;

public record CategoryUpdateUseCaseOutput(CategoryId id, String name, String description, boolean isActive,
        Instant createdAt, Instant updatedAt) {

    public static CategoryUpdateUseCaseOutput from(final Category category) {
        return new CategoryUpdateUseCaseOutput(category.getId(), category.getName(), category.getDescription(),
                category.isActive(), category.getCreatedAt(), category.getUpdatedAt());
    }
}
