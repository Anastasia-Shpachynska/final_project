package com.example.final_project.api.controller.personal;

import com.example.final_project.api.data.responce.ResponseData;
import com.example.final_project.api.data.responce.cart.CartData;
import com.example.final_project.api.data.responce.order.OrderData;
import com.example.final_project.facade.CartFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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

    @PostMapping({"/order"})
    public void addToOrder(@RequestBody OrderData data) {
        cartFacade.orderAdd(data);
    }
}
