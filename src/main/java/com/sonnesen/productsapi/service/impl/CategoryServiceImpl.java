package com.sonnesen.productsapi.service.impl;

import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.sonnesen.productsapi.model.Category;
import com.sonnesen.productsapi.model.CategoryId;
import com.sonnesen.productsapi.model.CategoryJPAEntity;
import com.sonnesen.productsapi.model.Page;
import com.sonnesen.productsapi.model.Pagination;
import com.sonnesen.productsapi.repository.CategoryJPARepository;
import com.sonnesen.productsapi.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryJPARepository categoryJPARepository;

    @Override
    @Transactional
    public Category create(final Category aCategory) {
        return save(aCategory);
    }

    @Override
    public Pagination<Category> findAll(final Page page) {
        final var withPage = Pageable.ofSize(page.perPage()).withPage(page.currentPage());
        final var pageResult = categoryJPARepository.findAll(withPage);

        final var pagination = new Pagination<>(
            pageResult.getNumber(),
            pageResult.getSize(),
            pageResult.getTotalElements(),
            pageResult.map(CategoryJPAEntity::toCategory).toList()
        );

        return pagination;
    }

    @Override
    public Optional<Category> findById(final CategoryId anId) {
        return categoryJPARepository.findById(anId.getValue()).map(CategoryJPAEntity::toCategory);
    }

    @Override
    @Transactional
    public void deleteById(final CategoryId anId) {
        categoryJPARepository.deleteById(anId.getValue());
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
