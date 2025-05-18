package com.sonnesen.productsapi.usecases.category.retrieve.list;

import java.time.Instant;
import com.sonnesen.productsapi.model.Category;
import com.sonnesen.productsapi.model.CategoryId;

public record CategoryListUseCaseOutput(CategoryId id, String name, String description, boolean active,
        Instant createdAt, Instant updatedAt) {

    public static CategoryListUseCaseOutput from(final Category category) {
        return new CategoryListUseCaseOutput(category.getId(), category.getName(), category.getDescription(),
                category.isActive(), category.getCreatedAt(), category.getUpdatedAt());
    }
}
