package com.sonnesen.productsapi.service;

import java.util.Optional;
import com.sonnesen.productsapi.model.Category;
import com.sonnesen.productsapi.model.CategoryId;
import com.sonnesen.productsapi.model.Page;
import com.sonnesen.productsapi.model.Pagination;

public interface CategoryService {

    Category create(Category aCategory);

    Category update(Category aCategory);

    Optional<Category> findById(CategoryId anId);

    Pagination<Category> findAll(Page page);

    void deleteById(CategoryId anId);

}
