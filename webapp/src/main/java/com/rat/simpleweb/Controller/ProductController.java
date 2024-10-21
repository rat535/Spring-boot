package com.rat.simpleweb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rat.simpleweb.model.productModel;
import com.rat.simpleweb.service.productService;

@RestController
public class ProductController {
	@Autowired
	productService service;
	
	@GetMapping("/products")
	public List<productModel> getProduct()
	{
		return service.getProducts();
	}
	@GetMapping("/products/{prodId}")
	public productModel getProductByid(@PathVariable int prodId) {
		return service.getProductById(prodId);
	}
	
	@PostMapping("/products")
	public void addProduct(@RequestBody productModel prod) {
		service.addProduct(prod);
	}

}
