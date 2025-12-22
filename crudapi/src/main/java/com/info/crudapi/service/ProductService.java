package com.info.crudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.crudapi.entity.Product;
import com.info.crudapi.repo.ProductRepository;

@Service
public class ProductService {
  private final ProductRepository productRepo;
  @Autowired
  public ProductService(ProductRepository productRepo) {
	  this.productRepo = productRepo;
  }
  
  public Product saveProduct(Product p) {
	  return productRepo.save(p);
  }
  
  public Product getProduct(int id) {
	  return productRepo.findById(id).orElse(null);
  }
  
  public Product deleteProduct(int id) {
	  Product dbProduct =  productRepo.findById(id).orElse(null);
      if(dbProduct != null) 
    	 productRepo.delete(dbProduct);
      return dbProduct;
  }
  
  public Product updateProduct(int id, Product p) {
	  Product dbProduct = productRepo.findById(id).orElse(null);
	  if(dbProduct!=null) {
		 return productRepo.save(p);
	  }
	  return dbProduct;
  }
  
  public List<Product> getAll(){
	  return productRepo.findAll();
  }
}










