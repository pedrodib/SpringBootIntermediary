package com.schoolofnet.SpringBootIntermediary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolofnet.SpringBootIntermediary.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
