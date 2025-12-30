package com.info.externalservice;

import java.util.HashMap;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.info.dto.CategoryResponseDTO;

@FeignClient(
		name="category-feign-client",
		url="https://dummyjson.com/")
public interface CategoryFeignClient {
  
  @GetMapping("/products/categories")	
  List<CategoryResponseDTO> getCategories();
}
