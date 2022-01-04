package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.product;

public interface ProductRepository extends JpaRepository<product,Integer>{

	product findByName(String name);

}
