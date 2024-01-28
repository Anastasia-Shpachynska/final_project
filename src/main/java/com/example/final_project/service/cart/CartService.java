package com.example.final_project.service.cart;

import com.example.final_project.api.data.responce.order.OrderData;
import com.example.final_project.persistence.entity.cart.Cart;
import com.example.final_project.service.CRUDService;

import java.util.Collection;

public interface CartService extends CRUDService<Cart> {

    Cart addToCart(Long productId);
    Collection<Cart> getCartDetails();
    void orderAdd(OrderData data);
    void removeOne(Long productId);
}
