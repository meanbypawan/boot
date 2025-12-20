package com.info.bootweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.bootweb.entity.Product;
import com.info.bootweb.service.ProductService;

@Controller
@RequestMapping("/product")
// http://localhost:8080/product
public class ProductController {
  @Autowired	
  private ProductService productService;
  
  @PostMapping
  @ResponseBody
  public Product save(@RequestBody Product p) {
	  return productService.saveProduct(p);
  }
  
  @GetMapping
  @ResponseBody
  public List<Product> getList(){
	  return productService.getList();
  }

}