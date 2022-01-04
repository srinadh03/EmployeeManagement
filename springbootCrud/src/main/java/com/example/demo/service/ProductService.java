package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.product;
import com.example.demo.repositary.ProductRepository;



@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public product saveProduct(product productt) {
		return repository.save(productt);
		
	}
	
	public List<product> saveProducts(List<product> products) {
		return repository.saveAll(products);
		
		
	}
	
	public List<product> getProducts() {
		return repository.findAll();
	}
	

	public product getProductbyId(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public product getProductbyname(String name) {
		return repository.findByName(name);
	}
	
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "product removed"+id;
	}
	public product updateProduct(product Product) {
		product existingProduct=repository.findById(Product.getId()).orElse(null);
		existingProduct.setName(Product.getName());
		existingProduct.setPrice(Product.getPrice());
		existingProduct.setQuantity(Product.getQuantity());
		return repository.save(existingProduct);
		
	}


}
