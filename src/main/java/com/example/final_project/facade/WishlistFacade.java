package com.example.final_project.facade;

import com.example.final_project.api.data.responce.wishlist.WishlistData;

public interface WishlistFacade {
    WishlistData addToWishlist(Long productId);
}
