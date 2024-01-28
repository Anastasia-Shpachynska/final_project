package com.example.final_project.facade.impl;

import com.example.final_project.api.data.responce.wishlist.WishlistData;
import com.example.final_project.facade.WishlistFacade;
import com.example.final_project.service.wishlist.WishlistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WishlistFacadeImpl implements WishlistFacade {

    private final WishlistService wishlistService;

    @Override
    public WishlistData addToWishlist(Long productId) {
        return new WishlistData(wishlistService.addToWishlist(productId));
    }
}
