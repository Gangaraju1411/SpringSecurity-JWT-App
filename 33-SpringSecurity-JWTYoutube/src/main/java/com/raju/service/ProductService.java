package com.raju.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.raju.entity.Product;
@Component
public interface ProductService {
	
	public Product saveProduct(Product product);
	public List<Product> fetchAllProducts();
	public Product fetchProduct(Integer id) ;

}
