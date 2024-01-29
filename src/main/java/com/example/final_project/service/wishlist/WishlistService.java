package com.example.final_project.service.wishlist;

import com.example.final_project.persistence.entity.wishlist.Wishlist;
import com.example.final_project.service.CRUDService;

import java.util.Collection;

public interface WishlistService extends CRUDService<Wishlist> {

    Wishlist addToWishlist(Long productId);
    Collection<Wishlist> getWishlist();
    void removeProduct(Long id);
}
