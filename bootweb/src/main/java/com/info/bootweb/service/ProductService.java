package com.info.bootweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.bootweb.entity.Product;
import com.info.bootweb.repo.ProductRepository;

@Service
public class ProductService {
  private final ProductRepository productRepo;
  
  @Autowired
  public ProductService(ProductRepository productRepo) {
	  this.productRepo = productRepo;
  }
  
  public Product saveProduct(Product p) {
	  return this.productRepo.save(p);
  }
  
  public List<Product> getList(){
	  return productRepo.findAll();
  }
}
