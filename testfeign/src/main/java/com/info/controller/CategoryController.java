package com.info.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.dto.CategoryResponseDTO;
import com.info.externalservice.CategoryFeignClient;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    CategoryFeignClient categoryClient;
    public CategoryController(CategoryFeignClient categoryClient) {
    	this.categoryClient = categoryClient;
    }
	@GetMapping
	public ResponseEntity<List<CategoryResponseDTO>> getCategories(){
		List<CategoryResponseDTO> list = categoryClient.getCategories();
		return ResponseEntity.ok(list);
	}
}
