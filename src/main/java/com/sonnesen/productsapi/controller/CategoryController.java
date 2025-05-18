package com.sonnesen.productsapi.controller;

import java.net.URI;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.sonnesen.categories.api.CategoriesApi;
import com.sonnesen.categories.model.CategoryDTO;
import com.sonnesen.categories.model.CreateCategoryDTO;
import com.sonnesen.categories.model.PaginatedCategoriesDTO;
import com.sonnesen.categories.model.UpdateCategoryDTO;
import com.sonnesen.productsapi.mappers.CategoryMapper;
import com.sonnesen.productsapi.model.Page;
import com.sonnesen.productsapi.model.Pagination;
import com.sonnesen.productsapi.usecases.category.create.CategoryCreateUseCase;
import com.sonnesen.productsapi.usecases.category.delete.CategoryDeleteUseCase;
import com.sonnesen.productsapi.usecases.category.retrieve.get.CategoryGetByIdUseCase;
import com.sonnesen.productsapi.usecases.category.retrieve.list.CategoryListUseCase;
import com.sonnesen.productsapi.usecases.category.update.CategoryUpdateUseCase;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CategoryController implements CategoriesApi {

    private final CategoryCreateUseCase categoryCreateUseCase;
    private final CategoryListUseCase categoryListUseCase;
    private final CategoryGetByIdUseCase categoryGetByIdUseCase;
    private final CategoryDeleteUseCase categoryDeleteUseCase;
    private final CategoryUpdateUseCase categoryUpdateUseCase;
    private final CategoryMapper categoryMapper;

    @Override
    public ResponseEntity<CategoryDTO> createCategory(final CreateCategoryDTO body) {
        final var useCaseInput = categoryMapper.fromDTO(body);
        final var useCaseOutput = categoryCreateUseCase.execute(useCaseInput);
        final var uri = URI.create("/categories/" + useCaseOutput.id());
        return ResponseEntity.created(uri).body(categoryMapper.toDTO(useCaseOutput));
    }

    @Override
    public ResponseEntity<Void> deleteCategory(final UUID categoryId) {
        categoryDeleteUseCase.execute(categoryId.toString());
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<CategoryDTO> getCategory(final UUID categoryId) {
        final var output = categoryMapper.toDTO(categoryGetByIdUseCase.execute(categoryId.toString()));
        return ResponseEntity.ok(output);
    }

    @Override
    public ResponseEntity<CategoryDTO> updateCategory(final UUID categoryId, final UpdateCategoryDTO body) {
        final var input = categoryMapper.fromDTO(categoryId.toString(), body);
        final var output = categoryUpdateUseCase.execute(input);
        return ResponseEntity.ok(categoryMapper.toDTO(output));
    }

    @Override
    public ResponseEntity<PaginatedCategoriesDTO> listCategories(final Integer page, final Integer perPage) {
        Pagination<CategoryDTO> categories = categoryListUseCase.execute(new Page(page, perPage)).mapItems(categoryMapper::toDTO);

        PaginatedCategoriesDTO paginatedCategories = new PaginatedCategoriesDTO()
            .items(categories.items())
            .page(categories.currentPage())
            .perPage(categories.perPage())
            .total(categories.total());

        return ResponseEntity.ok(paginatedCategories);
    }

}
