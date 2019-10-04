package com.hcl.ingproduct.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ingproduct.entity.Product;
import com.hcl.ingproduct.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts(int categoryId) {
		List<Product> productList=productRepository.findByCategoryId(categoryId);
		return productList;
	}

	@Override
	public Product getProductDetails(int productId) {
		Optional<Product> product=productRepository.findById(productId);
		Product productInfo=null;
		if(product.isPresent()) {
			productInfo=product.get();
		}
		return productInfo;
	}

}
