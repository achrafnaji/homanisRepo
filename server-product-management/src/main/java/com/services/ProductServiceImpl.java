package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.Product;
import com.repository.ProductRepository;

public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product saveProduct(final Product product) {
		return productRepository.save(product);
	}
	@Override
	public Product updateProduct(final Product product) {
		return productRepository.save(product);
	}
	@Override
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);
	}
	@Override
	public Long numbersOfProduct() {
		return productRepository.count();
	}
	@Override
	public List<Product> findAllProducts(){
		return productRepository.findAll();
	}
}
