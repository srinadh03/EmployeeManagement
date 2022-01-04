package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	public product addproduct(@RequestBody product Product) {
		return service.saveProduct(Product);
	}
	
	@PostMapping("/addProducts")
	public List<product> addproducts(@RequestBody List<product> Products) {
		return service.saveProducts(Products);
	}
	@GetMapping("/allproducts")
	public List<product> findAllproducts() {
		return service.getProducts();
	}
	
	@GetMapping("/product/{id}")
	public product findproductbyid(@PathVariable int id) {
		return service.getProductbyId(id);
	}
	
	@GetMapping("/product/{name}")
	public product findproductbyname(@PathVariable String name) {
		return service.getProductbyname(name);
	}
	
	@PutMapping("/update")
	public product updateproduct(@RequestBody product Product) {
		return service.updateProduct(Product);
	}
	@DeleteMapping("/delete/{id}")
	public String deleProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}

}
