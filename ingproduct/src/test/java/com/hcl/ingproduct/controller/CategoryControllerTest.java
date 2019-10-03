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

import com.hcl.ingproduct.dto.CategoryResponseDto;
import com.hcl.ingproduct.entity.Category;
import com.hcl.ingproduct.service.CategoryServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {
			
	@Mock
	CategoryServiceImpl categoryServiceImpl;
	@InjectMocks
	CategoryController categoryController;
	Category category=new Category();
	@Before
	public void initiateDate() {
		category.setCategoryId(1);
		category.setCategoryName("Mortgage");
	}
	
	@Test
	public void testGetCategoryList() {
		List<Category> categoryList=new ArrayList<>();
		categoryList.add(category);
		Mockito.when(categoryServiceImpl.getAllProductCategory()).thenReturn(categoryList);
		ResponseEntity<CategoryResponseDto> categoryResponse=categoryController.getCategoryList();
		assertNotNull(categoryResponse);
		assertEquals(200, categoryResponse.getStatusCode().value());
		
	}
}
