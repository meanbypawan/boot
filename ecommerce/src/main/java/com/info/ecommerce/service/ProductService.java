package com.info.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.info.ecommerce.dto.ProductResponseDTO;
import com.info.ecommerce.entity.Category;
import com.info.ecommerce.entity.Product;
import com.info.ecommerce.exception.ResourceNotFoundException;
import com.info.ecommerce.repo.CategoryRepository;
import com.info.ecommerce.repo.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
  private ProductRepository productRepo;
  private CategoryRepository categoryRepo;
  public ProductService(ProductRepository productRepo, CategoryRepository categoryRepo) {
	  this.productRepo = productRepo;
	  this.categoryRepo = categoryRepo;
  }
  public List<ProductResponseDTO> saveInBulk(int categoryId , List<Product> list){
	 Category dbCategory =  categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category not found"));
     for(Product p: list)
    	 p.setCategory(dbCategory);
     
     List<Product>dbProductList =  productRepo.saveAll(list); 
  
     List<ProductResponseDTO> dtoList = new ArrayList<>();
     for(Product p: dbProductList) {
    	 ProductResponseDTO productDTO = new ProductResponseDTO();
    	 productDTO.setId(p.getId());
    	 productDTO.setTitle(p.getTitle());
    	 productDTO.setPrice(p.getPrice());
    	 productDTO.setBrand(p.getBrand());
    	 productDTO.setCategoryId(p.getCategory().getId());
    	 productDTO.setCategoryName(p.getCategory().getCategoryName());
    	 dtoList.add(productDTO);
     }
     return dtoList;
  }
  @Transactional
  public ProductResponseDTO save(int categoryId, Product product) {
    Category dbCategory =  categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category not found"));	  
    product.setCategory(dbCategory);
    Product dbProduct =  productRepo.save(product);
    ProductResponseDTO dto = new ProductResponseDTO();
    dto.setId(dbProduct.getId());
    dto.setCategoryId(categoryId);
    dto.setCategoryName(dbCategory.getCategoryName());
    dto.setPrice(dbProduct.getPrice());
    dto.setBrand(dbProduct.getBrand());
    dto.setTitle(dbProduct.getTitle());
    return dto;
  }
  public List<ProductResponseDTO> getList(){
    List<Product> productList =  productRepo.findAll();	  
  
    List<ProductResponseDTO> dtoList = new ArrayList<>();
    for(Product p : productList) {
    	ProductResponseDTO productDTO = new ProductResponseDTO();
    	productDTO.setId(p.getId());
    	productDTO.setTitle(p.getTitle());
    	productDTO.setPrice(p.getPrice());
    	productDTO.setBrand(p.getBrand());
    	productDTO.setCategoryId(p.getCategory().getId());
    	productDTO.setCategoryName(p.getCategory().getCategoryName());
    	dtoList.add(productDTO);
    }
    return dtoList;
  }
  public List<ProductResponseDTO> getProductPerPage(int page, int size){
     Pageable pageable =  PageRequest.of(page,size);	  
     
     Page<Product> pageItem =  productRepo.findAll(pageable);
     
     List<Product> productList =  pageItem.get().toList();
     List<ProductResponseDTO> dtoList = new ArrayList<>();
     for(Product p : productList) {
     	ProductResponseDTO productDTO = new ProductResponseDTO();
     	productDTO.setId(p.getId());
     	productDTO.setTitle(p.getTitle());
     	productDTO.setPrice(p.getPrice());
     	productDTO.setBrand(p.getBrand());
     	productDTO.setCategoryId(p.getCategory().getId());
     	productDTO.setCategoryName(p.getCategory().getCategoryName());
     	dtoList.add(productDTO);
     }
     return dtoList;
  }
}














