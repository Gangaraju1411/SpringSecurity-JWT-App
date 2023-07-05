package com.raju.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raju.entity.Product;
import com.raju.repo.ProductRepository;
import com.raju.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	boolean flag;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	
	@Override
	public List<Product> fetchAllProducts() {

		return productRepository.findAll();
	}
	
	@Override
	public Product fetchProduct(Integer id) {
		Product product = null;
		if(id != null && id != 0) {
			flag = productRepository.existsById(id);
		}
		if(flag) 
			product = productRepository.findById(id).get();
		else
			throw new RuntimeException("Product Not Found");
		return product;
	}

	
}
