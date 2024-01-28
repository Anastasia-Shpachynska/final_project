package com.example.final_project.persistence.entity.wishlist;

import com.example.final_project.persistence.entity.BaseEntity;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.persistence.entity.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Wishlist extends BaseEntity {

    @ManyToOne
    private User user;

    @ManyToOne
    private ProductVariant productVariant;

    public Wishlist(User user, ProductVariant productVariant) {
        super();
        this.user = user;
        this.productVariant = productVariant;
    }

    public Wishlist() {}
}
