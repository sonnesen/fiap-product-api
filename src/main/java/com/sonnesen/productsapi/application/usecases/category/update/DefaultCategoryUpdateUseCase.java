package com.sonnesen.productsapi.application.usecases.category.update;

import com.sonnesen.productsapi.application.domain.category.CategoryId;
import com.sonnesen.productsapi.application.exceptions.NotFoundException;
import com.sonnesen.productsapi.application.repositories.CategoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultCategoryUpdateUseCase extends CategoryUpdateUseCase {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryUpdateUseCaseOutput execute(CategoryUpdateUseCaseInput input) {
        final var categoryId = CategoryId.from(input.id());

        final var category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Category with ID %s not found.".formatted(categoryId)));

        category.update(input.name(), input.description(), input.isActive());
        this.categoryRepository.update(category);

        return CategoryUpdateUseCaseOutput.from(category);
    }

}
