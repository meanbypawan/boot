package com.info.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.info.ecommerce.dto.CategoryResponseDTO;
import com.info.ecommerce.entity.Category;
import com.info.ecommerce.exception.ResourceNotFoundException;
import com.info.ecommerce.repo.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoryService {
  private CategoryRepository categoryRepo;
  public CategoryService(CategoryRepository categoryRepo) {
	  this.categoryRepo = categoryRepo;
  }
  
  @Transactional
  public CategoryResponseDTO save(Category category) {
	  Category dbCategory =  categoryRepo.save(category);
      CategoryResponseDTO dto = new CategoryResponseDTO();
      dto.setId(dbCategory.getId());
      dto.setCategoryName(dbCategory.getCategoryName());
      return dto;
  }
  
  @Transactional
  public List<CategoryResponseDTO> saveInBulk(List<Category> categoryList){
	 List<Category> list =  categoryRepo.saveAll(categoryList);
     List<CategoryResponseDTO> dtoList = new ArrayList<CategoryResponseDTO>();
     
     for(Category c : list) {
    	 CategoryResponseDTO categoryDTO = new CategoryResponseDTO();
    	 categoryDTO.setId(c.getId());
    	 categoryDTO.setCategoryName(c.getCategoryName());
    	 dtoList.add(categoryDTO);
     }
     return dtoList;
  }
  
  public List<CategoryResponseDTO> fetchCategories(){
	  List<Category> list = categoryRepo.findAll();
	  List<CategoryResponseDTO> dtoList = new ArrayList<>();
	  for(Category c : list) {
		  CategoryResponseDTO dto = new CategoryResponseDTO();
		  dto.setId(c.getId());
		  dto.setCategoryName(c.getCategoryName());
		  dtoList.add(dto);
	  }
	  return dtoList;
  }
  
  public CategoryResponseDTO fetchCategoryById(int categoryId) {
     Category dbCategory =  categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category not found"));	  
     CategoryResponseDTO dto = new CategoryResponseDTO();
     dto.setId(dbCategory.getId()); 
     dto.setCategoryName(dbCategory.getCategoryName());
     return dto;
  }
}








