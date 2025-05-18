package com.sonnesen.productsapi.usecases.category.update;

import org.springframework.stereotype.Component;
import com.sonnesen.productsapi.exception.NotFoundException;
import com.sonnesen.productsapi.model.CategoryId;
import com.sonnesen.productsapi.service.CategoryService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryUpdateUseCase {

    private final CategoryService categoryRepository;

    public CategoryUpdateUseCaseOutput execute(final CategoryUpdateUseCaseInput input) {
        final var categoryId = CategoryId.from(input.id());

        final var category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Category with ID %s not found.".formatted(categoryId)));

        category.update(input.name(), input.description(), input.isActive());
        this.categoryRepository.update(category);

        return CategoryUpdateUseCaseOutput.from(category);
    }

}
