package com.sonnesen.productsapi.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sonnesen.productsapi.infrastructure.persistence.entities.CategoryJPAEntity;

public interface CategoryJPARepository extends JpaRepository<CategoryJPAEntity, String> {

}
