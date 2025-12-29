package com.info.ecommerce.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.ecommerce.entity.Cart;
import com.info.ecommerce.entity.CartItems;
import com.info.ecommerce.entity.Product;

@Repository
public interface CartItemRepo extends JpaRepository<CartItems, Integer>{
     Optional<CartItems> findByCartAndProduct(Cart cart, Product product);
}
