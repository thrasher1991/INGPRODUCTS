package com.hcl.ingproduct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ingproduct.entity.Category;
import com.hcl.ingproduct.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;
	

    /**
    * @author Subashri Sridharan
    *
    */
	
	@Override
	public List<Category> getAllProductCategory() {
		List<Category> categoryList=categoryRepository.findAll();
		return categoryList;
	}

}
