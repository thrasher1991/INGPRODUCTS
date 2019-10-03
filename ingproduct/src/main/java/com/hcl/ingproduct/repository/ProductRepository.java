package com.hcl.ingproduct.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ingproduct.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Optional<Product> findByProductNameAndProductDescription(String productName, String productDescrition);
}
