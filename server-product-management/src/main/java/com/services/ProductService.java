package com.services;

import java.util.List;

import com.model.Product;

public interface ProductService {

	Product saveProduct(Product product);

	Product updateProduct(Product product);

	void deleteProduct(Long productId);

	Long numbersOfProduct();

	List<Product> findAllProducts();

}
