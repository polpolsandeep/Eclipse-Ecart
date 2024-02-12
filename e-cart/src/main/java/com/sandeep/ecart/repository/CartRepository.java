package com.sandeep.ecart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandeep.ecart.model.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {

	List<Cart> findAllByUserId(int userId);
}
