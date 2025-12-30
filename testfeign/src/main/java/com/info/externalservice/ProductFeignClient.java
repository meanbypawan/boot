package com.info.externalservice;

import java.util.HashMap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
		name = "product-feign-client",
		url="https://dummyjson.com/products")
public interface ProductFeignClient {
  
  @GetMapping	
  HashMap<String, Object> getProducts();
  
  @GetMapping("/{id}")
  Object getProductById(@PathVariable int id);
  
  @DeleteMapping("/{id}")
  Object deleteProduct(@PathVariable int id);
}
