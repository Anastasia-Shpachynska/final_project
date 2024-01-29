package com.example.final_project.facade;

import com.example.final_project.api.data.responce.wishlist.WishlistData;

import java.util.Collection;

public interface WishlistFacade {
    WishlistData addToWishlist(Long productId);
    Collection<WishlistData> getWishlist();
    void removeProduct(Long id);
}
