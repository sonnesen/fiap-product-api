package com.sonnesen.productsapi.usecases.category.create;

import org.springframework.stereotype.Component;
import com.sonnesen.productsapi.model.Category;
import com.sonnesen.productsapi.service.CategoryService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryCreateUseCase {

    private final CategoryService categoryRepository;

    public CategoryCreateUseCaseOutput execute(final CategoryCreateUseCaseInput input) {
        final var newCategory = Category.newCategory(input.name(), input.description());
        final var category = categoryRepository.create(newCategory);
        return CategoryCreateUseCaseOutput.from(category);
    }

}
