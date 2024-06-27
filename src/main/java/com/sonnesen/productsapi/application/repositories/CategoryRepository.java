package com.sonnesen.productsapi.application.repositories;

import java.util.List;
import java.util.Optional;

import com.sonnesen.productsapi.application.domain.category.Category;
import com.sonnesen.productsapi.application.domain.category.CategoryId;

public interface CategoryRepository {

    Category create(Category aCategory);

    Category update(Category aCategory);

    Optional<Category> findById(CategoryId anId);

    List<Category> findAll();

    void deleteById(CategoryId anId);

}
