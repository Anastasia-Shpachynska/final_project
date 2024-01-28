package com.example.final_project.facade;

import com.example.final_project.api.data.responce.cart.CartData;
import com.example.final_project.api.data.responce.order.OrderData;

import java.util.Collection;

public interface CartFacade {
    CartData addToCart(Long productId);
    Collection<CartData> getCartDetails();
    void orderAdd(OrderData data);
    void removeOne(Long productId);
}
