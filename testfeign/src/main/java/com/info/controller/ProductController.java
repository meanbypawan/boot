package com.info.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.externalservice.ProductFeignClient;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
    private ProductFeignClient productClient;
	
	@GetMapping
	public ResponseEntity<HashMap<String, Object>> getProducts(){
		HashMap<String,Object> hm =  productClient.getProducts();
	    return ResponseEntity.ok(hm);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable int id){
		return ResponseEntity.ok(productClient.getProductById(id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable int id){
		return ResponseEntity.ok(productClient.deleteProduct(id));
	}
}










