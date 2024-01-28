package com.example.final_project.facade.impl;

import com.example.final_project.api.data.responce.cart.CartData;
import com.example.final_project.api.data.responce.order.OrderData;
import com.example.final_project.facade.CartFacade;
import com.example.final_project.persistence.entity.cart.Cart;
import com.example.final_project.service.cart.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class CartFacadeImpl implements CartFacade {
    private final CartService cartService;

    public CartData addToCart(Long productId) {
        Cart cart = cartService.addToCart(productId);
        return new CartData(cart);
    }

    @Override
    public Collection<CartData> getCartDetails() {
        return cartService.getCartDetails().stream().map(CartData::new).toList();
    }

    @Override
    public void orderAdd(OrderData data) {
        cartService.orderAdd(data);
    }

    @Override
    public void removeOne(Long productId) {
        cartService.removeOne(productId);
    }
}
