package com.sonnesen.productsapi.mappers;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.sonnesen.categories.model.CategoryDTO;
import com.sonnesen.categories.model.CreateCategoryDTO;
import com.sonnesen.categories.model.UpdateCategoryDTO;
import com.sonnesen.productsapi.model.Category;
import com.sonnesen.productsapi.model.CategoryId;
import com.sonnesen.productsapi.usecases.category.create.CategoryCreateUseCaseInput;
import com.sonnesen.productsapi.usecases.category.create.CategoryCreateUseCaseOutput;
import com.sonnesen.productsapi.usecases.category.retrieve.get.CategoryGetByIdUseCaseOutput;
import com.sonnesen.productsapi.usecases.category.retrieve.list.CategoryListUseCaseOutput;
import com.sonnesen.productsapi.usecases.category.update.CategoryUpdateUseCaseInput;
import com.sonnesen.productsapi.usecases.category.update.CategoryUpdateUseCaseOutput;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(category.getId().getValue()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(category.getCreatedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(category.getUpdatedAt()))")
    CategoryDTO toDTO(Category category);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().getValue()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
    CategoryDTO toDTO(CategoryCreateUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().getValue()))")
    CategoryDTO toDTO(CategoryListUseCaseOutput output);

    List<CategoryDTO> toDTO(List<CategoryListUseCaseOutput> output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().getValue()))")
    @Mapping(target = "active", source = "isActive")
    CategoryDTO toDTO(CategoryGetByIdUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().getValue()))")
    @Mapping(target = "active", source = "isActive")
    CategoryDTO toDTO(CategoryUpdateUseCaseOutput output);

    CategoryCreateUseCaseInput fromDTO(CreateCategoryDTO dto);

    @Mapping(target = "id", source = "categoryId")
    @Mapping(target = "isActive", source = "dto.active")
    CategoryUpdateUseCaseInput fromDTO(String categoryId, UpdateCategoryDTO dto);

    default OffsetDateTime mapOffsetDateTime(Instant instant) {
        if (instant == null) {
            return null;
        }
        return OffsetDateTime.ofInstant(instant, java.time.ZoneOffset.UTC);
    }

    default String map(CategoryId value) {
        return value.toString();
    }

}
