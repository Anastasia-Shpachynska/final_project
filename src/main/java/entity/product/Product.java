package entity.product;

import entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import persistence.type.AuthorType;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 4096)
    private String description;

    @Column(name = "pages_count", nullable = false)
    private int pagesCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "author_type", nullable = false)
    private AuthorType productAuthor;

    @ManyToMany
    @JoinTable(
            name = "thumbnails",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "product_image_id")
    )
    private Set<ProductImage> productImages;

    public Product() {
        this.productImages = new HashSet<>();
    }
}
