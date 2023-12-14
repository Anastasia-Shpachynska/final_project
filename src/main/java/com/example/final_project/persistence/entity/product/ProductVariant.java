package com.example.final_project.persistence.entity.product;

import com.example.final_project.persistence.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "product_variant")
public class ProductVariant extends BaseEntity {

    @ManyToOne
    public Product product;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal price;
}