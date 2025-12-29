package com.info.ecommerce.service;

import java.net.http.WebSocket.Listener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.info.ecommerce.dto.AddToCartRequestDTO;
import com.info.ecommerce.dto.CartResponseDTO;
import com.info.ecommerce.entity.Cart;
import com.info.ecommerce.entity.CartItems;
import com.info.ecommerce.entity.Product;
import com.info.ecommerce.entity.User;
import com.info.ecommerce.exception.ResourceNotFoundException;
import com.info.ecommerce.repo.CartItemRepo;
import com.info.ecommerce.repo.CartRepo;
import com.info.ecommerce.repo.ProductRepository;
import com.info.ecommerce.repo.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class CartService {
    private UserRepository userRepo;
    private CartRepo cartRepo;
    private CartItemRepo cartItemRepo;
    private ProductRepository productRepo;
    public CartService(UserRepository userRepo, CartRepo cartRepo, CartItemRepo cartItemRepo, ProductRepository productRepo) {
    	this.userRepo = userRepo;
    	this.cartRepo = cartRepo;
    	this.cartItemRepo = cartItemRepo;
    	this.productRepo = productRepo;
    }
    
    @Transactional
	public HashMap<String, String> addToCart(AddToCartRequestDTO cartDTO) {
      User dbUser =  userRepo.findById(cartDTO.getUserId()).orElseThrow(()->new ResourceNotFoundException("User not found"));
	  
      Product dbProduct = productRepo.findById(cartDTO.getProductId()).orElseThrow(()->new ResourceNotFoundException("Product not found"));
      
      Cart cart =  cartRepo.findByUser(dbUser).orElseGet(()->{
		  Cart newCart = new Cart();
		  newCart.setUser(dbUser);
		  return cartRepo.save(newCart);
	  });
	  
      Optional<CartItems> optional =  cartItemRepo.findByCartAndProduct(cart,dbProduct);
      HashMap<String, String> hm = new HashMap<>();
      if(optional.isPresent()) {
    	  hm.put("message", "Item is already added in cart");
      }
      else {
    	  // 
    	  CartItems cartItems = new CartItems();
    	  cartItems.setCart(cart);
    	  cartItems.setProduct(dbProduct);
    	  cartItemRepo.save(cartItems);
          hm.put("message", "Item is successfully added in cart");
      }
      return hm;
	}
    public HashMap<String, List<CartResponseDTO>> fetchCartDetails(int userId) {
    	User dbUser =  userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found"));
    	Cart cart =  dbUser.getCart();
    	List<CartResponseDTO> productList = new ArrayList<>();
    	if(cart!=null) {
    	  List<CartItems> itemList =  cart.getItemList();
    	  for(CartItems item : itemList) {
    		  Product p =  item.getProduct();
    		  CartResponseDTO dto = new CartResponseDTO();
    		  dto.setId(p.getId());
    		  dto.setTitle(p.getTitle());
    		  dto.setBrand(p.getBrand());
    		  dto.setPrice(p.getPrice());
    		  productList.add(dto);
    	  }
    	}
    	HashMap<String, List<CartResponseDTO>> hm = new HashMap<>();
    	hm.put("cart-details", productList);
    	return hm;
    }
}













