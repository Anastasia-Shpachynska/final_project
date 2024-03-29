package com.example.final_project.service.wishlist.impl;

import com.example.final_project.config.filter.AuthenticationFilter;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.persistence.entity.user.User;
import com.example.final_project.persistence.entity.wishlist.Wishlist;
import com.example.final_project.persistence.repository.product.ProductVariantRepository;
import com.example.final_project.persistence.repository.user.PersonalRepository;
import com.example.final_project.persistence.repository.wishlist.WishlistRepository;
import com.example.final_project.service.wishlist.WishlistService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Transactional
@AllArgsConstructor
public class WishlistServiceImpl implements WishlistService {

    private final PersonalRepository personalRepository;
    private final WishlistRepository wishlistRepository;
    private final ProductVariantRepository productVariantRepository;

    @Override
    public void create(Wishlist entity) {

    }

    @Override
    public void update(Wishlist entity) {

    }

    @Override
    public Wishlist findById(Long id) {
        return null;
    }

    @Override
    public Collection<Wishlist> findAll() {
        return null;
    }

    @Override
    public Wishlist addToWishlist(Long productId) {
        ProductVariant productVariant = productVariantRepository.findProductVariantById(productId);
        String username = AuthenticationFilter.CURRENT_USER;
        User user = personalRepository.findByUsername(username).orElse(null);

        Collection<Wishlist> wishlistCollection = getWishlist();
        for (Wishlist wishlist1 : wishlistCollection) {
            if(wishlist1.getProductVariant().getId().equals(productId)) {
                return null;
            }
        }
        if(user != null && productVariant != null) {
            Wishlist wishlist = new Wishlist(user, productVariant);
            return wishlistRepository.save(wishlist);
        }
        return null;
    }

    @Override
    public Collection<Wishlist> getWishlist() {
        String username = AuthenticationFilter.CURRENT_USER;
        User user = personalRepository.findByUsername(username).orElse(null);
        if(user != null) {
            return wishlistRepository.findAllByUser(user);
        }
        return null;
    }

    @Override
    @Transactional
    public void removeProduct(Long id) {
        String username = AuthenticationFilter.CURRENT_USER;
        User user = personalRepository.findByUsername(username).orElse(null);
        ProductVariant productVariant = productVariantRepository.findById(id).orElse(null);
        if(user != null && productVariant != null) {
            wishlistRepository.deleteWishlistByUserAndProductVariant(user, productVariant);
        }
    }
}
