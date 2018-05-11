package com.schoolofnet.SpringBootIntermediary.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolofnet.SpringBootIntermediary.models.Product;
import com.schoolofnet.SpringBootIntermediary.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.repository = productRepository;
	}
	
	@Override
	public List<Product> all() {		
		return repository.findAll();
	}

	@Override
	public Product get(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public Product create(Product product) {
		repository.save(product);
		return product;
	}

	@Override
	public Product update(Long id, Product product) {
		Product newProduct = repository.findById(id).get();
		
		if(newProduct != null) {
			product.setId(newProduct.getId());
			repository.save(product);
			
			return product;
		}
		
		return null;
	}

	@Override
	public void delete(Long id) {
		Product product = repository.findById(id).get();
		
		if(product != null) 
			repository.delete(product);
		
	}

}
