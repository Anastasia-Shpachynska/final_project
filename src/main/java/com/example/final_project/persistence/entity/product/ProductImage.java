package com.example.final_project.persistence.entity.product;

import com.example.final_project.persistence.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name= "product_images")
public class ProductImage extends BaseEntity {

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "main_image", nullable = false)
    private Boolean mainImage;

    @ManyToMany(mappedBy = "productImages")
    private Set<ProductVariant> productVariants;

    public ProductImage() {
        super();
        this.productVariants = new HashSet<>();
        this.mainImage = false;
    }
}