package com.hcl.ingproduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ingproduct.dto.ProductDetailsResponseDto;
import com.hcl.ingproduct.entity.Product;
import com.hcl.ingproduct.service.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class ProductController {
	
	@Autowired
	ProductService productService;
	

    /**
    * @author Shilendra Singh
    *
    */
	
	@GetMapping("/prodcuts/{productId}")
	public ResponseEntity<ProductDetailsResponseDto> getProductDetails(@PathVariable int productId) {
		ProductDetailsResponseDto productInfo=new ProductDetailsResponseDto();
		Product productDetails = productService.getProductDetails(productId);
		productInfo.setSattusCode(200);
		productInfo.setProductId(productDetails.getProductId());
		productInfo.setProductDescription(productDetails.getProductDescription());
		productInfo.setProductName(productDetails.getProductName());
		productInfo.setMessage("product list");
		return new ResponseEntity<>(productInfo, HttpStatus.OK);

	}

}
