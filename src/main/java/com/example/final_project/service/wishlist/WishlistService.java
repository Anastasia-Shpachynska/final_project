package com.example.final_project.service.wishlist;

import com.example.final_project.persistence.entity.wishlist.Wishlist;
import com.example.final_project.service.CRUDService;

public interface WishlistService extends CRUDService<Wishlist> {

    Wishlist addToWishlist(Long productId);
}
