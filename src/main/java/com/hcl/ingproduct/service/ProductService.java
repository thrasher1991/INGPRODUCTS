package com.hcl.ingproduct.service;

import java.util.List;

import com.hcl.ingproduct.entity.Product;

public interface ProductService {
		List<Product> getAllProducts(int categoryId);
		Product getProductDetails(int productId);
}
