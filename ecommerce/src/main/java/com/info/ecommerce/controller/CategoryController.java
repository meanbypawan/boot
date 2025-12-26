package com.info.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.ecommerce.dto.CategoryResponseDTO;
import com.info.ecommerce.entity.Category;
import com.info.ecommerce.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
    	this.categoryService = categoryService;
    }
	@PostMapping
	public ResponseEntity<CategoryResponseDTO> save(@RequestBody Category category){
		return ResponseEntity.ok(categoryService.save(category));
	}
	@PostMapping("/bulk")
	public ResponseEntity<List<CategoryResponseDTO>> saveInBulk(@RequestBody List<Category> list){
		return ResponseEntity.ok(categoryService.saveInBulk(list));
	}
	@GetMapping
	public ResponseEntity<List<CategoryResponseDTO>> fetchCategory(){
		return ResponseEntity.ok(categoryService.fetchCategories());
	}
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryResponseDTO> fetchCategoryById(@PathVariable int categoryId){
	   return ResponseEntity.ok(categoryService.fetchCategoryById(categoryId));	
	}
}








