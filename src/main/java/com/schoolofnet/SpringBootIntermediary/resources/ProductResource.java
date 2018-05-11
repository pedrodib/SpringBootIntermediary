package com.schoolofnet.SpringBootIntermediary.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.schoolofnet.SpringBootIntermediary.models.Product;
import com.schoolofnet.SpringBootIntermediary.services.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API REST - Model Product")
@RestController
@RequestMapping(path="/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	public ProductResource(ProductService productService) {
		this.service = productService;
	}
	
	@ApiOperation(value="Find all products in database")
	@GetMapping(produces="application/json")
	@ResponseStatus(code=HttpStatus.OK)
	public @ResponseBody ResponseEntity<?> all() {
		List<Product> list = service.all();
		
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value="Get by id in database")
	@GetMapping(value="/{id}", produces="application/json")
	@ResponseStatus(code=HttpStatus.OK)
	public @ResponseBody ResponseEntity<?> get(@PathVariable(value="id") Long id) {
		Product product = service.get(id); 
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@ApiOperation(value="Create a new product")
	@PostMapping(produces="application/json")
	@ResponseStatus(code=HttpStatus.CREATED)
	public @ResponseBody ResponseEntity<?> create(@Valid @RequestBody Product product, Errors errors) {
		if(!errors.hasErrors()){
			Product created = service.create(product); 
			return new ResponseEntity<Product>(created, HttpStatus.CREATED);
		}
		return ResponseEntity.badRequest()
				.body(errors.getAllErrors()
						.stream()
						.map(msg -> msg.getDefaultMessage())
						.collect(Collectors.joining(",")));
	}
	
	@ApiOperation(value="Update a product by id")
	@PutMapping(value="/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public @ResponseBody ResponseEntity<?> update(@PathVariable(value="id") Long id,@Valid @RequestBody Product product, Errors errors) {
		if(!errors.hasErrors()) {
			Product updated = service.update(id, product);
			return new ResponseEntity<Product>(updated, HttpStatus.OK);
		}
		
		return ResponseEntity.badRequest()
				.body(errors.getAllErrors()
						.stream()
						.map(msg -> msg.getDefaultMessage())
						.collect(Collectors.joining(",")));
	}
	
	@ApiOperation(value="Delete product by id")
	@DeleteMapping(value="/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public @ResponseBody void delete(@PathVariable(value="id") Long id) {
		service.delete(id);
	}
	
	
}
