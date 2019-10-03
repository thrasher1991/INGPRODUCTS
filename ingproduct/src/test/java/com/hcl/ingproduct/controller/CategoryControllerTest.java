package com.hcl.ingproduct.controller;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hcl.ingproduct.controller.CategoryController;
import com.hcl.ingproduct.dto.ProductResponseDto;
import com.hcl.ingproduct.entity.Category;
import com.hcl.ingproduct.entity.Product;
import com.hcl.ingproduct.service.CategoryServiceImpl;
import com.hcl.ingproduct.service.ProductServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {
	
	@Mock
	CategoryServiceImpl categoryServiceImpl;
	@Mock
	ProductServiceImpl productServiceImpl;
	@InjectMocks
	CategoryController categoryController;
	Category category=new Category();
	Product product=new Product();
	@Before
	public void initiateData() {
		category.setCategoryId(1);
		category.setCategoryName("Mortgage");
		product.setCategoryId(1);
		product.setProductDescription("Banking");
		product.setProductId(1);
		product.setProductName("Linear");
	}
	
	@Test
	public void testgetAllProducts() {
		List<Product>productList=new ArrayList<>();
		productList.add(product);
		Mockito.when(productServiceImpl.getAllProducts(Mockito.anyInt())).thenReturn(productList);
		ResponseEntity<ProductResponseDto> productResponse=categoryController.getAllProducts(1);
		assertNotNull(productResponse);
		assertEquals(200, productResponse.getStatusCode().value());
	}
}
