package com.info.ecommerce.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.info.ecommerce.dto.ProductResponseDTO;
import com.info.ecommerce.entity.Product;
import com.info.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
  private ProductService productService;
  public ProductController(ProductService productService) {
	  this.productService = productService;
  }
  @PostMapping("/category/{categoryId}")	
  public ResponseEntity<ProductResponseDTO> save(@PathVariable int categoryId, @RequestBody Product product) {
	ProductResponseDTO dbProduct =  productService.save(categoryId, product);
    return ResponseEntity.status(HttpStatus.CREATED).body(dbProduct);
  }
  @PostMapping("/category/{categoryId}/bulk")
  public ResponseEntity<List<ProductResponseDTO>> saveInBulk(@PathVariable int categoryId,@RequestBody List<Product> list){
	 List<ProductResponseDTO> dtoList =  productService.saveInBulk(categoryId, list);
     return ResponseEntity.status(HttpStatus.CREATED).body(dtoList);
  }
  @GetMapping
  public ResponseEntity<List<ProductResponseDTO>> getList(){
	  return ResponseEntity.ok(productService.getList());
  }
  @GetMapping("/page")
  public ResponseEntity<List<ProductResponseDTO>> getProductPerPage(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size){
	return ResponseEntity.ok(productService.getProductPerPage(page, size));  
  }
}











