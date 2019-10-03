package com.hcl.ingproduct.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ingproduct.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Optional<Category> findByCategoryName(String categoryName);
}
