package com.hcl.ingproduct.dto;

import java.util.List;

import com.hcl.ingproduct.entity.Category;
public class CategoryResponseDto {
	private int statusCode;
	private String message;
	private List<Category> categoryList;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	
	
}
