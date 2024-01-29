package com.example.final_project.facade.impl;

import com.example.final_project.api.data.responce.wishlist.WishlistData;
import com.example.final_project.facade.WishlistFacade;
import com.example.final_project.persistence.entity.wishlist.Wishlist;
import com.example.final_project.service.wishlist.WishlistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class WishlistFacadeImpl implements WishlistFacade {

    private final WishlistService wishlistService;

    @Override
    public WishlistData addToWishlist(Long productId) {
        return new WishlistData(wishlistService.addToWishlist(productId));
    }

    @Override
    public Collection<WishlistData> getWishlist() {
        return wishlistService.getWishlist().stream().map(WishlistData::new).toList();
    }

    @Override
    public void removeProduct(Long id) {
        wishlistService.removeProduct(id);
    }
}
