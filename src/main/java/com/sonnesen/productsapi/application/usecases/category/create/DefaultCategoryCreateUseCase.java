package com.sonnesen.productsapi.application.usecases.category.create;

import com.sonnesen.productsapi.application.domain.category.Category;
import com.sonnesen.productsapi.application.repositories.CategoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultCategoryCreateUseCase extends CategoryCreateUseCase {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryCreateUseCaseOutput execute(CategoryCreateUseCaseInput input) {
        final var newCategory = Category.newCategory(input.name(), input.description(), input.active());
        final var category = categoryRepository.create(newCategory);
        return CategoryCreateUseCaseOutput.from(category);
    }

}
