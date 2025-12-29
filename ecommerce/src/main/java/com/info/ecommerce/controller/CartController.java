package com.info.ecommerce.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.ecommerce.dto.AddToCartRequestDTO;
import com.info.ecommerce.dto.CartResponseDTO;
import com.info.ecommerce.entity.Cart;
import com.info.ecommerce.entity.Product;
import com.info.ecommerce.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private CartService cartService;
    public CartController(CartService cartService) {
    	this.cartService = cartService;
    }
	@PostMapping
	public ResponseEntity<HashMap<String, String>> addToCart(@RequestBody AddToCartRequestDTO cartDTO){
		HashMap<String, String>hm  = cartService.addToCart(cartDTO);
		return ResponseEntity.ok(hm);
	}
	@GetMapping("/{userId}")
	public ResponseEntity<HashMap<String, List<CartResponseDTO>>> fetchCartDetails(@PathVariable int userId){
	  HashMap<String, List<CartResponseDTO>> hm = cartService.fetchCartDetails(userId);
	  return ResponseEntity.ok(hm);	
	}
}
