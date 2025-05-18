package com.sonnesen.productsapi.usecases.category.retrieve.get;

import org.springframework.stereotype.Component;
import com.sonnesen.productsapi.exception.NotFoundException;
import com.sonnesen.productsapi.model.CategoryId;
import com.sonnesen.productsapi.service.CategoryService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryGetByIdUseCase {

    private final CategoryService categoryRepository;

    public CategoryGetByIdUseCaseOutput execute(final String input) {
        final var categoryId = CategoryId.from(input);

        return categoryRepository.findById(categoryId)
                .map(CategoryGetByIdUseCaseOutput::from)
                .orElseThrow(() -> new NotFoundException("Category with ID %s not found.".formatted(categoryId)));
    }

}
