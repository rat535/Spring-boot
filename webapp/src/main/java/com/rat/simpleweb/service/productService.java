package com.rat.simpleweb.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rat.simpleweb.model.productModel;

@Service
public class productService {
	List<productModel> products = new ArrayList<>(Arrays.asList(new productModel(101,"Rat",5000),new productModel(102,"Ratnesh",6000) ));
	public List<productModel> getProducts(){
		return products;
	}
	public productModel getProductById(int prodId) {
		for (productModel product : products) {
	        if (product.getProdId() == prodId) {
	            return product;
	        }
	        
	    }
	    return null; 
	}
	public void addProduct(productModel prod) {
		products.add(prod);
	}
}
