package com.schoolofnet.SpringBootIntermediary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.schoolofnet.SpringBootIntermediary.resources.ProductResource;

@SpringBootApplication
public class SpringBootIntermediaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootIntermediaryApplication.class, args);
	}
}
