package com.project.BlogApp.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryDto {
	private Integer categoryId;

	@NotBlank
	@Size(min = 4, message = " Min size of category title is 4")
	private String categoryTittle;

	@NotBlank
	@Size(min = 10, message = " Min size of category Description is 10")
	private String categoryDescription;

	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDto(Integer categoryId, String categoryTittle, String categoryDescription) {
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

}
