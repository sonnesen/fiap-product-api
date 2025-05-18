package com.sonnesen.productsapi.usecases.category.retrieve.list;

import org.springframework.stereotype.Component;
import com.sonnesen.productsapi.model.Page;
import com.sonnesen.productsapi.model.Pagination;
import com.sonnesen.productsapi.service.CategoryService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryListUseCase {

    private final CategoryService categoryRepository;

    public Pagination<CategoryListUseCaseOutput> execute(final Page page) {
        return categoryRepository.findAll(page).mapItems(CategoryListUseCaseOutput::from);
    }

}
