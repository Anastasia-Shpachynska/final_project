package com.example.final_project.persistence.entity.order;

import com.example.final_project.persistence.entity.BaseEntity;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.persistence.entity.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table
public class OrderProducts extends BaseEntity {
    @ManyToOne
    private User user;

    @ManyToOne
    private ProductVariant productVariant;

    @Column(nullable = false)
    private int count;

    @Column(nullable = false)
    private boolean status;
}
