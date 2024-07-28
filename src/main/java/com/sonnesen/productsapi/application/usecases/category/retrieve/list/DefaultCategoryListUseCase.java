package com.sonnesen.productsapi.application.usecases.category.retrieve.list;

import com.sonnesen.productsapi.application.domain.pagination.Page;
import com.sonnesen.productsapi.application.domain.pagination.Pagination;
import com.sonnesen.productsapi.application.repositories.CategoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultCategoryListUseCase extends CategoryListUseCase {

    private final CategoryRepository categoryRepository;

    @Override
    public Pagination<CategoryListUseCaseOutput> execute(final Page page) {
        return categoryRepository.findAll(page).mapItems(CategoryListUseCaseOutput::from);
    }

}
