package com.project.BlogApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.BlogApp.Service.CategoryService;
import com.project.BlogApp.payload.ApiResponse;
import com.project.BlogApp.payload.CategoryDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	//CREATE
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto)
	{
		CategoryDto create = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(create,HttpStatus.CREATED);
	}
	
	//UPDATE
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> update(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer id )
	{
		CategoryDto updated = this.categoryService.updateCategory(categoryDto,id);
		return new ResponseEntity<CategoryDto>(updated,HttpStatus.OK);
	}
	
	//DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Integer id )
	{
		this.categoryService.deleteCategory(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category is deleted",false),HttpStatus.OK);
	}
	
	//GeT
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> get(@PathVariable Integer id )
	{
		CategoryDto get = this.categoryService.getCategory(id);
		return new ResponseEntity<CategoryDto>(get,HttpStatus.OK);
	}
	
	//GETALL
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAll()
	{
		List<CategoryDto> categories = this.categoryService.getCategories();
		return new ResponseEntity<List<CategoryDto>>(categories, HttpStatus.OK);
	}

}
