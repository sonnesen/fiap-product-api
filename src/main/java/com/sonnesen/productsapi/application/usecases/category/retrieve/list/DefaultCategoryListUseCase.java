package com.sonnesen.productsapi.application.usecases.category.retrieve.list;

import java.util.List;

import com.sonnesen.productsapi.application.repositories.CategoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultCategoryListUseCase extends CategoryListUseCase {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryListUseCaseOutput> execute() {
        return categoryRepository.findAll().stream()
                .map(CategoryListUseCaseOutput::from)
                .toList();
    }

}
