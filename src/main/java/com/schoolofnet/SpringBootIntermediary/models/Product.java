package com.schoolofnet.SpringBootIntermediary.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message="Name cannot be empty")
	@NotBlank(message="Name cannot be blank")
	@Size(min=4, max=255)
	private String name;
	
	@NotNull(message="Name cannot be empty")
	@Min(value=0)
	@Max(value=1000)
	private Integer qtd;
	
	private Date date_created;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(String name, Integer qtd) {
		this.name = name;
		this.qtd = qtd;
	}
	
	@PrePersist
	public void onPrePersist() {
		if(this.date_created == null)
			this.date_created = new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	
	@Override
	public String toString() {
		return "{ id: " + this.id + " name: " + this.name + ", qtd: " + this.qtd + ", dateCreated: " + this.date_created + "}";
	}
}
