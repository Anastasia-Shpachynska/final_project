package com.example.final_project.persistence.repository.cart;

import com.example.final_project.persistence.entity.cart.Cart;
import com.example.final_project.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CartRepository extends BaseRepository<Cart> {
    Collection<Cart> findAllByUserId(Long userId);
}
