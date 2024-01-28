package com.example.final_project.service.cart.impl;

import com.example.final_project.api.data.responce.cart.CartData;
import com.example.final_project.api.data.responce.order.OrderData;
import com.example.final_project.config.filter.AuthenticationFilter;
import com.example.final_project.persistence.entity.cart.Cart;
import com.example.final_project.persistence.entity.order.OrderDetails;
import com.example.final_project.persistence.entity.order.OrderProducts;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.persistence.entity.user.User;
import com.example.final_project.persistence.repository.cart.CartRepository;
import com.example.final_project.persistence.repository.order.OrderDetailsRepository;
import com.example.final_project.persistence.repository.order.OrderProductsRepository;
import com.example.final_project.persistence.repository.product.ProductVariantRepository;
import com.example.final_project.persistence.repository.user.PersonalRepository;
import com.example.final_project.service.cart.CartService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductVariantRepository productVariantRepository;
    private final PersonalRepository personalRepository;
    private final OrderDetailsRepository orderDetailsRepository;
    private final OrderProductsRepository orderProductsRepository;

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

    @Override
    @Transactional
    public void orderAdd(OrderData data) {
        List<OrderProducts> orderProductsList = new ArrayList<>();

        for (CartData cartDatum : data.getCartItems()) {
            User user = personalRepository.findByUsername(cartDatum.getUsername()).orElse(null);

            if (user != null) {
                ProductVariant productVariant = productVariantRepository.findProductVariantById(cartDatum.getId());

                OrderProducts orderProducts = new OrderProducts();
                orderProducts.setUser(user);
                orderProducts.setProductVariant(productVariant);
                orderProducts.setCount(cartDatum.getCount());

                orderProductsList.add(orderProducts);
            }
        }

        if (!orderProductsList.isEmpty()) {
            orderProductsRepository.saveAll(orderProductsList);

            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setUser(orderProductsList.get(0).getUser());
            orderDetails.setFirstName(data.getData().getFirstName());
            orderDetails.setLastName(data.getData().getLastName());
            orderDetails.setPhoneNumber(data.getData().getPhoneNumber());
            orderDetails.setCity(data.getData().getCity());
            orderDetails.setPost(data.getData().getPostNumber());
            orderDetails.setTotalSum(new BigDecimal(data.getTotalSum()));
            orderDetails.setStatus(false);

            orderDetailsRepository.save(orderDetails);
        }

        cartRepository.cleanCart(orderProductsList.get(0).getUser().getId());
    }

    @Override
    public void removeOne(Long productId) {
        String username = AuthenticationFilter.CURRENT_USER;
        User user = (User) personalRepository.findByUsername(username).orElse(null);
        Long userId = user.getId();
        if(userId != null) {
            cartRepository.deleteCartByUserIdAndProductVariantId(userId, productId);
        }
    }
}
