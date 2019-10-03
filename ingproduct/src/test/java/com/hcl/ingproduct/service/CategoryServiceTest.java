package com.hcl.ingproduct.service;

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

import com.hcl.ingproduct.entity.Category;
import com.hcl.ingproduct.repository.CategoryRepository;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {
	@Mock
	CategoryRepository categoryRepository;
	@InjectMocks
	CategoryServiceImpl categoryService;
	Category category=new Category();
	@Before
	public void initiateDate() {
		category.setCategoryId(1);
		category.setCategoryName("Mortgage");
	}
	
	@Test
	public void testGetAllCategory() {
		List<Category> categoryList=new ArrayList<>();
		categoryList.add(category);
		Mockito.when(categoryRepository.findAll()).thenReturn(categoryList);
		List<Category> categoryInfo=categoryService.getAllProductCategory();
		assertNotNull(categoryInfo);		
	}
}
