package com.hcl.ingproduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ingproduct.dto.CategoryResponseDto;
import com.hcl.ingproduct.entity.Category;
import com.hcl.ingproduct.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class CategoryController {
	
	@Autowired 
	CategoryService categoryService;
	

           /**
           * @author Subashri Sridharan
           *
           */
	
	@GetMapping("/category")
	public ResponseEntity<CategoryResponseDto> getCategoryList() {
		CategoryResponseDto categoryResponse=new CategoryResponseDto();
		List<Category> categoryList=categoryService.getAllProductCategory();
		categoryResponse.setCategoryList(categoryList);
		categoryResponse.setMessage("List of Category");
		categoryResponse.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(categoryResponse,HttpStatus.OK);
	}
	
}
