package com.sonnesen.productsapi.infrastructure.persistence.entities;

import java.time.Instant;

import com.sonnesen.productsapi.application.domain.category.Category;
import com.sonnesen.productsapi.application.domain.category.CategoryId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class CategoryJPAEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true, length = 36)
    private String id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    public static CategoryJPAEntity of(Category newCategory) {
        return new CategoryJPAEntity(newCategory.getId().value(), newCategory.getName(), newCategory.getDescription(),
                newCategory.isActive(), newCategory.getCreatedAt(), newCategory.getUpdatedAt(),
                newCategory.getDeletedAt());
    }

    public Category toCategory() {
        return Category.with(CategoryId.from(id), name, description, active, createdAt, updatedAt, deletedAt);
    }
}
