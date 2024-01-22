package com.example.final_project.service.cart.impl;

import com.example.final_project.config.filter.AuthenticationFilter;
import com.example.final_project.persistence.entity.cart.Cart;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.persistence.entity.user.User;
import com.example.final_project.persistence.repository.cart.CartRepository;
import com.example.final_project.persistence.repository.product.ProductVariantRepository;
import com.example.final_project.persistence.repository.user.PersonalRepository;
import com.example.final_project.service.cart.CartService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductVariantRepository productVariantRepository;
    private final PersonalRepository personalRepository;

    @Override
    public void create(Cart entity) {

    }

    @Override
    public void update(Cart entity) {

    }

    @Override
    public Cart findById(Long id) {
        return null;
    }

    @Override
    public Collection<Cart> findAll() {
        return null;
    }

    @Override
    public Cart addToCart(Long productId) {
       ProductVariant productVariant = productVariantRepository.findProductVariantById(productId);
       String username = AuthenticationFilter.CURRENT_USER;

       User user = null;
       if(username != null) {
           user = personalRepository.findByUsername(username).get();
       }
       Collection<Cart> carts = getCartDetails();
        for (Cart cart : carts) {
            if(cart.getProductVariant().getId().equals(productId)) {
                return null;
            }
        }
       if(productVariant != null && user != null) {
           Cart cart = new Cart(productVariant, user);
           return cartRepository.save(cart);
       }
        return null;
    }

    public Collection<Cart> getCartDetails() {
        String username = AuthenticationFilter.CURRENT_USER;
        User user = (User) personalRepository.findByUsername(username).orElse(null);
        return cartRepository.findAllByUserId(user.getId());
    }
}
