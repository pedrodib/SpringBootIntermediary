package com.schoolofnet.SpringBootIntermediary.services;

import java.util.List;

import com.schoolofnet.SpringBootIntermediary.models.Product;

public interface ProductService {
	public List<Product> all();
	public Product get(Long id);
	public Product create(Product product);
	public Product update(Long id, Product product);
	public void delete(Long id);
}
