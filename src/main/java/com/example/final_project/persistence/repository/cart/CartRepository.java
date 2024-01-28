package com.example.final_project.persistence.repository.cart;

import org.springframework.data.jpa.repository.Modifying;

import com.example.final_project.persistence.entity.cart.Cart;
import com.example.final_project.persistence.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CartRepository extends BaseRepository<Cart> {
    Collection<Cart> findAllByUserId(Long userId);

    @Modifying
    @Query("delete from Cart c where c.user.id = :userId and c.productVariant.id = :productId")
    void deleteCartByUserIdAndProductVariantId(@Param("userId") Long userId, @Param("productId") Long productId);

    @Modifying
    @Query("delete from Cart c where c.user.id = :userId")
    void cleanCart(@Param("userId") Long userId);
}
