package com.example.final_project.facade;

import com.example.final_project.api.data.responce.product.CartData;
import com.example.final_project.persistence.entity.cart.Cart;

import java.util.Collection;
import java.util.List;

public interface CartFacade {
    CartData addToCart(Long productId);
     Collection<CartData> getCartDetails();
}
