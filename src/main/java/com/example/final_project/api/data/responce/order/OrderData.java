package com.example.final_project.api.data.responce.order;

import com.example.final_project.api.data.responce.cart.CartData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderData {
    private List<CartData> cartItems;
    private ContactData data;
    private String totalSum;
}
