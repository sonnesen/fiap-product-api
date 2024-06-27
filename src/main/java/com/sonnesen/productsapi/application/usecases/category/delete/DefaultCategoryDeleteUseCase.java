package com.sonnesen.productsapi.application.usecases.category.delete;

import com.sonnesen.productsapi.application.domain.category.CategoryId;
import com.sonnesen.productsapi.application.repositories.CategoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultCategoryDeleteUseCase extends CategoryDeleteUseCase {

    private final CategoryRepository categoryRepository;

    @Override
    public void execute(final String input) {
        final var categoryId = CategoryId.from(input);
        categoryRepository.deleteById(categoryId);
    }

}
