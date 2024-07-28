package com.sonnesen.productsapi.application.usecases.category.retrieve.list;

import com.sonnesen.productsapi.application.domain.pagination.Page;
import com.sonnesen.productsapi.application.domain.pagination.Pagination;
import com.sonnesen.productsapi.application.usecases.UseCase;

public abstract class CategoryListUseCase extends UseCase<Page, Pagination<CategoryListUseCaseOutput>> {

}
