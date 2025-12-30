package com.info.service;

import org.springframework.stereotype.Service;

import com.info.repo.CategoryRepository;

@Service
public class CategoryService {
  private CategoryRepository categoryRepo;
  
  public CategoryService(CategoryRepository categoryRepo) {
	  this.categoryRepo = categoryRepo;
  }
  
  
}
