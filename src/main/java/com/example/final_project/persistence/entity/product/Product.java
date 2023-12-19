package com.example.final_project.persistence.entity.product;

import com.example.final_project.persistence.entity.BaseEntity;
import com.example.final_project.persistence.type.AuthorType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "author_type", nullable = false)
    private AuthorType productAuthor;

    @Column(name = "pages_count", nullable = false)
    private int pagesCount;
}
