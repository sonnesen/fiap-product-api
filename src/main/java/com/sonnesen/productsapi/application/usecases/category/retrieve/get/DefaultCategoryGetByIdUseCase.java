package com.sonnesen.productsapi.application.usecases.category.retrieve.get;

import com.sonnesen.productsapi.application.domain.category.CategoryId;
import com.sonnesen.productsapi.application.exceptions.NotFoundException;
import com.sonnesen.productsapi.application.repositories.CategoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultCategoryGetByIdUseCase extends CategoryGetByIdUseCase {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryGetByIdUseCaseOutput execute(String input) {
        final var categoryId = CategoryId.from(input);

        return categoryRepository.findById(categoryId)
                .map(CategoryGetByIdUseCaseOutput::from)
                .orElseThrow(() -> new NotFoundException("Category with ID %s not found.".formatted(categoryId)));
    }

}
