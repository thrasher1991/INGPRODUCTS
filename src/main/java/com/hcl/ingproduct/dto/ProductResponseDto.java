package com.hcl.ingproduct.dto;

import java.util.List;

import com.hcl.ingproduct.entity.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
	
	private String message;
	private Integer statusCode;
	private List<Product> productList;

}
