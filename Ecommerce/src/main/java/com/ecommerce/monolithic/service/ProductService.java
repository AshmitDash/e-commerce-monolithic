package com.ecommerce.monolithic.service;

import java.util.List;

import java.util.UUID;

import com.ecommerce.monolithic.entity.Product;

public interface ProductService {

	Product createProduct(Product product);

	Product updateProduct(UUID id, Product product);

	void deleteProduct(UUID id);

	Product getProductById(UUID id);

	List<Product> getAllProducts();

	List<Product> getProductsByCategory(String category);
}
