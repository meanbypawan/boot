package com.info.bootjpa;

import com.info.bootjpa.entity.Product;
import com.info.bootjpa.service.ProductService;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootjpaApplication {

    private final ProductService productService;

    BootjpaApplication(ProductService productService) {
        this.productService = productService;
    }

	public static void main(String[] args) {
	 ApplicationContext context = SpringApplication.run(BootjpaApplication.class, args);
	 ProductService productService =  context.getBean(ProductService.class);
	 List<Product>list =  productService.getProductList();
	 for(Product p : list)
		 System.out.println(p.getTitle()+"  "+p.getBrand());
//	 Product p = new Product();
//	 p.setTitle("Samsung f41");
//	 p.setBrand("Samsung");
//	 p.setPrice(25000);
//	 p.setDiscount(5.5f);
//	
//	 Product dbProduct =  productService.saveProduct(p);
//	 if(dbProduct!=null)
//		 System.out.println("Product save..");
//	 else
//		 System.out.println("Not saved...");
//	 
	}

}
