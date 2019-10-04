package com.hcl.ingproduct.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ingproduct.entity.Product;
import com.hcl.ingproduct.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	@InjectMocks
	ProductServiceImpl productServiceImpl;

	@Mock
	ProductRepository productRepository;

	Product product;

	List<Product> productList;

	@Before
	public void initiateData() {
		product = new Product();
		product.setCategoryId(1);
		product.setProductDescription("Banking");
		product.setProductId(1);
		product.setProductName("Linear");

		productList = new ArrayList<>();
		productList.add(product);
	}

	@Test
	public void testGetAllProducts() {
		productList.add(product);
		Mockito.when(productRepository.findByCategoryId(Mockito.anyInt())).thenReturn(productList);
		List<Product> productInfo = productServiceImpl.getAllProducts(1);
		assertNotNull(productInfo);

	}
	
	@Test
	public void testGetProductDetails() {
		Optional<Product> productInfo=Optional.of(product);
		Mockito.when(productRepository.findById(Mockito.anyInt())).thenReturn(productInfo);
		Product productDetail=productServiceImpl.getProductDetails(1);
		assertNotNull(productDetail);
		
		
	}
	
}
