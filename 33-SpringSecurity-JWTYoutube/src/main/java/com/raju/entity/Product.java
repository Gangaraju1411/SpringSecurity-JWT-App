package com.raju.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import lombok.Data;

@Entity
@Data
@Table(name="youtube_security")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer produtct_id;
	
	@NotNull(message="Product name should not be null")
	@NotEmpty(message="Product name should not be empty")
	private String productName;
	
	@NotNull(message="Price name should not be null")
	@NotEmpty(message="Price name should not be empty")
	@Min(value = 10)
	@Max(value = 100000)
	private String price;
	
	@NotNull(message="Department name should not be null")
	@NotEmpty(message="Department name should not be empty")
	private String dept;
	
	
}
