package com.ecommerce.monolithic.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.monolithic.entity.Product;
import com.ecommerce.monolithic.service.ProductServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@PostMapping("/create-product")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return ResponseEntity.ok(productServiceImpl.createProduct(product));
	}

	@GetMapping("/find-all-products")
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productServiceImpl.getAllProducts());
	}

	@GetMapping("/find-products-by-id/{id}")
	public ResponseEntity<Product> getProductsById(@PathVariable("id") UUID id) {
		return ResponseEntity.ok(productServiceImpl.getProductById(id));
	}

	@GetMapping("/find-products-by-category/{category}")
	public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("category") String category) {
		return ResponseEntity.ok(productServiceImpl.getProductsByCategory(category));
	}
}
