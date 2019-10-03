package com.hcl.ingproduct.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetailsResponseDto {
	private String message;
	private Integer sattusCode;
	private String productName;
	private String productDescription;
	private Integer productId;
}
