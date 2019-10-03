package com.hcl.ingproduct.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hcl.ingproduct.dto.ProductDetailsResponseDto;
import com.hcl.ingproduct.entity.Product;
import com.hcl.ingproduct.service.ProductServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {
	@Mock
	ProductServiceImpl productServiceImpl;
	@InjectMocks
	ProductController productController;
	Product product=new Product();
	
	@Before
	public void initiateData() {
		product.setCategoryId(1);
		product.setProductDescription("Banking");
		product.setProductId(1);
		product.setProductName("Linear");
	}
	@Test
	public void testProductDetails() {
		Mockito.when(productServiceImpl.getProductDetails(1)).thenReturn(product);
		ResponseEntity<ProductDetailsResponseDto> productDetails=productController.getProductDetails(1);
		assertNotNull(productDetails);
		assertEquals(200,productDetails.getStatusCode().value());
	}
}
