package com.sonnesen.productsapi.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import com.sonnesen.productsapi.application.domain.category.Category;
import com.sonnesen.productsapi.application.domain.category.CategoryId;
import com.sonnesen.productsapi.application.repositories.CategoryRepository;
import com.sonnesen.productsapi.infrastructure.persistence.entities.CategoryJPAEntity;
import com.sonnesen.productsapi.infrastructure.persistence.repositories.CategoryJPARepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryJPARepository categoryJPARepository;

    @Override
    @Transactional
    public Category create(final Category aCategory) {
        return save(aCategory);
    }

    @Override
    public List<Category> findAll() {
        return categoryJPARepository.findAll().stream().map(CategoryJPAEntity::toCategory).toList();
    }

    @Override
    public Optional<Category> findById(final CategoryId anId) {
        return categoryJPARepository.findById(anId.value()).map(CategoryJPAEntity::toCategory);
    }

    @Override
    @Transactional
    public void deleteById(final CategoryId anId) {
        categoryJPARepository.deleteById(anId.value());
    }

    @Override
    @Transactional
    public Category update(final Category aCategory) {
        return save(aCategory);
    }

    private Category save(final Category category) {
        return categoryJPARepository.save(CategoryJPAEntity.of(category)).toCategory();
    }

}
