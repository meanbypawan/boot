package com.info.crudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.crudapi.entity.Product;
import com.info.crudapi.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
  @Autowired	
  private ProductService productService;

  @PostMapping
  public ResponseEntity<Product> create(@RequestBody Product p) {
	try {  
	  Product dbProduct = productService.saveProduct(p);
	  return ResponseEntity.status(201).body(dbProduct);
	}
	catch(Exception e) {
		return ResponseEntity.internalServerError().build();
	}
  }
  @GetMapping
  public ResponseEntity<List<Product>> fetchAll(){
	  try {  
		  List<Product> list = productService.getAll();
		  return ResponseEntity.ok().body(list);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}  
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<Product> deleteProduct(@PathVariable int id){
	  try {
		 Product deletedProduct =  productService.deleteProduct(id); 
		 if(deletedProduct !=null)
			 return ResponseEntity.ok().body(deletedProduct);
	     return ResponseEntity.notFound().build();
	  }
	  catch(Exception e) {
		  return ResponseEntity.internalServerError().build();
	  }
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product p){
	  try {
		  Product updatedProduct =  productService.updateProduct(id, p);
	      if(updatedProduct != null)
	    	  return ResponseEntity.ok().body(updatedProduct);
	      return ResponseEntity.notFound().build();
	  }
	  catch(Exception e) {
		  return ResponseEntity.internalServerError().build();
	  }
  }
  @GetMapping("/{id}")
  public ResponseEntity<Product> getProduct(@PathVariable int id){
	  try {
		  Product dbProduct =  productService.getProduct(id);
	      if(dbProduct != null)
	    	  return ResponseEntity.ok().body(dbProduct);
	      return ResponseEntity.notFound().build();
	  }
	  catch(Exception e) {
		  return ResponseEntity.internalServerError().build();
	  }
  }
}







