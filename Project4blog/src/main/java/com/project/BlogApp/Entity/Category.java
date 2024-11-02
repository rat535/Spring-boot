package com.project.BlogApp.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="categories")
public class Category {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer categoryId;
	
	@Column(name= "title",nullable = false)
	private String categoryTittle;
	
	@Column(name = "description")
	private String categoryDescription;
	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Category(Integer categoryId, String categoryTittle, String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryTittle = categoryTittle;
		this.categoryDescription = categoryDescription;
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryTittle() {
		return categoryTittle;
	}
	public void setCategoryTittle(String categoryTittle) {
		this.categoryTittle = categoryTittle;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	private List<Post> post = new ArrayList<>();
	
}
