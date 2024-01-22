package com.example.final_project.persistence.entity.cart;

import com.example.final_project.persistence.entity.BaseEntity;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.persistence.entity.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
public class Cart extends BaseEntity {

    @ManyToOne
    private ProductVariant productVariant;

    @ManyToOne
    private User user;

    public Cart(ProductVariant productVariant, User user) {
        super();
        this.productVariant = productVariant;
        this.user = user;
    }

    public Cart() {

    }
}
