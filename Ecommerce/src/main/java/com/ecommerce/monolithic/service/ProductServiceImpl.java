package com.ecommerce.monolithic.service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.monolithic.entity.Product;
import com.ecommerce.monolithic.exception.ResourceNotFoundException;
import com.ecommerce.monolithic.repository.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(UUID id, Product productDetails) {
		// TODO Auto-generated method stub
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
		
		product.setName(productDetails.getName());
		product.setCategory(productDetails.getCategory());
		product.setDescription(productDetails.getDescription());
		product.setPrice(productDetails.getPrice());
		product.setQuantity(productDetails.getQuantity());
		
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(UUID id) {
		// TODO Auto-generated method stub
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
		productRepository.delete(product);
	}

	@Override
	public Product getProductById(UUID id) {
		// TODO Auto-generated method stub
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		// TODO Auto-generated method stub
		return productRepository.findByCategory(category);
	}

}

