package com.hcl.ingproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ingproduct.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
