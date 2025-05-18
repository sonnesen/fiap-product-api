package com.sonnesen.productsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sonnesen.productsapi.model.CategoryJPAEntity;

public interface CategoryJPARepository extends JpaRepository<CategoryJPAEntity, String> {

}
