package com.example.final_project.api.controller.personal;

import com.example.final_project.api.data.responce.ResponseData;
import com.example.final_project.api.data.responce.product.CartData;
import com.example.final_project.facade.CartFacade;
import com.example.final_project.persistence.entity.cart.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/private/personal/cart")
public class CartController {

    private final CartFacade cartFacade;

    @GetMapping({"/addToCart/{productId}"})
    public ResponseEntity<ResponseData<CartData>> addToCart(@PathVariable(name = "productId") Long productId) {
        return ResponseEntity.ok(new ResponseData<>(cartFacade.addToCart(productId)));
    }

    @GetMapping({"/getCartDetails"})
    public ResponseEntity<ResponseData<Collection<CartData>>> getCartDetails() {
        return ResponseEntity.ok(new ResponseData<>(cartFacade.getCartDetails()));
    }
}
