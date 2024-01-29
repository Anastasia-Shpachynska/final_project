package com.example.final_project.persistence.repository.wishlist;

import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.persistence.entity.user.User;
import com.example.final_project.persistence.entity.wishlist.Wishlist;
import com.example.final_project.persistence.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface WishlistRepository extends BaseRepository<Wishlist> {

    Collection<Wishlist> findAllByUser(User user);

    @Modifying
    void deleteWishlistByUserAndProductVariant(User user, ProductVariant productVariant);
}
