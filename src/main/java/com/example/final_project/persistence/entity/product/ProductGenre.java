package com.example.final_project.persistence.entity.product;

import com.example.final_project.persistence.entity.BaseEntity;
import com.example.final_project.persistence.type.GenreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "product_genres")
public class ProductGenre extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "genre_name", nullable = false, unique = true)
    private GenreType genreName;

    @ManyToMany(mappedBy = "productGenres")
    private Set<ProductVariant> productVariants;

    public ProductGenre() {
        super();
        this.productVariants = new HashSet<>();
    }
}
