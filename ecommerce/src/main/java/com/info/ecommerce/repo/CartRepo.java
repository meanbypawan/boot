package com.info.ecommerce.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.ecommerce.entity.Cart;
import com.info.ecommerce.entity.User;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
	// select * from cart where user_id = ?
	Optional<Cart> findByUser(User user);
}
