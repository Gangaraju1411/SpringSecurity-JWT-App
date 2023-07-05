package com.raju.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raju.binding.AuthRequest;
import com.raju.entity.Product;
import com.raju.service.ProductService;
import com.raju.service.impl.JwtService;

@RestController
@RequestMapping("/products")
public class ProductRestController {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(service.saveProduct(product),HttpStatus.OK);
	}
	
	@GetMapping("/fetch/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Product> fetchProduct(@PathVariable Integer id){
		return new ResponseEntity<Product>(service.fetchProduct(id),HttpStatus.OK);
	}
	
	@GetMapping("/fetchAll")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<List<Product>> fetchAllProducts(){
		return new ResponseEntity<List<Product>>(service.fetchAllProducts(),HttpStatus.OK);
	}
	
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if(authentication.isAuthenticated()) {
		return jwtService.generateToken(authRequest.getUsername());
		}else {
			throw new UsernameNotFoundException("Invalid User");
		}
	}
}
