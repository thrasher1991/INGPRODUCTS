package com.hcl.ingproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ingproduct.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
