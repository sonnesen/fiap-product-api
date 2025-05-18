package com.sonnesen.productsapi.usecases.category.delete;

import org.springframework.stereotype.Component;
import com.sonnesen.productsapi.model.CategoryId;
import com.sonnesen.productsapi.service.CategoryService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryDeleteUseCase {

    private final CategoryService categoryRepository;

    public void execute(final String input) {
        final var categoryId = CategoryId.from(input);
        categoryRepository.deleteById(categoryId);
    }

}
