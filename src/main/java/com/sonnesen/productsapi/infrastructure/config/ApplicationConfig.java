package com.sonnesen.productsapi.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sonnesen.productsapi.application.repositories.CategoryRepository;
import com.sonnesen.productsapi.application.usecases.category.create.CategoryCreateUseCase;
import com.sonnesen.productsapi.application.usecases.category.create.DefaultCategoryCreateUseCase;
import com.sonnesen.productsapi.application.usecases.category.delete.CategoryDeleteUseCase;
import com.sonnesen.productsapi.application.usecases.category.delete.DefaultCategoryDeleteUseCase;
import com.sonnesen.productsapi.application.usecases.category.retrieve.get.CategoryGetByIdUseCase;
import com.sonnesen.productsapi.application.usecases.category.retrieve.get.DefaultCategoryGetByIdUseCase;
import com.sonnesen.productsapi.application.usecases.category.retrieve.list.CategoryListUseCase;
import com.sonnesen.productsapi.application.usecases.category.retrieve.list.DefaultCategoryListUseCase;
import com.sonnesen.productsapi.application.usecases.category.update.CategoryUpdateUseCase;
import com.sonnesen.productsapi.application.usecases.category.update.DefaultCategoryUpdateUseCase;
import com.sonnesen.productsapi.infrastructure.persistence.repositories.CategoryJPARepository;
import com.sonnesen.productsapi.infrastructure.repositories.CategoryRepositoryImpl;

@Configuration
public class ApplicationConfig {

    @Bean
    public CategoryRepository categoryRepository(final CategoryJPARepository categoryJPARepository) {
        return new CategoryRepositoryImpl(categoryJPARepository);
    }

    @Bean
    public CategoryCreateUseCase categoryCreateUseCase(final CategoryRepository categoryRepository) {
        return new DefaultCategoryCreateUseCase(categoryRepository);
    }

    @Bean
    public CategoryListUseCase categoryListUseCase(final CategoryRepository categoryRepository) {
        return new DefaultCategoryListUseCase(categoryRepository);
    }

    @Bean
    public CategoryGetByIdUseCase categoryGetByIdUseCase(final CategoryRepository categoryRepository) {
        return new DefaultCategoryGetByIdUseCase(categoryRepository);
    }

    @Bean
    public CategoryDeleteUseCase categoryDeleteUseCase(final CategoryRepository categoryRepository) {
        return new DefaultCategoryDeleteUseCase(categoryRepository);
    }

    @Bean
    public CategoryUpdateUseCase categoryUpdateUseCase(final CategoryRepository categoryRepository) {
        return new DefaultCategoryUpdateUseCase(categoryRepository);
    }
}
