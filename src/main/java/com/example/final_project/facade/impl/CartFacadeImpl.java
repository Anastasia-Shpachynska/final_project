package com.example.final_project.facade.impl;

import com.example.final_project.api.data.responce.product.CartData;
import com.example.final_project.api.data.responce.product.ProductPLPData;
import com.example.final_project.api.data.responce.product.ProductVariantData;
import com.example.final_project.facade.CartFacade;
import com.example.final_project.persistence.entity.cart.Cart;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.service.cart.CartService;
import com.example.final_project.service.product.ProductVariantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
}
