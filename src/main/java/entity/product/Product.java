package entity.product;

import entity.BaseEntity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.access.method.P;
import persistence.type.AuthorType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "productsCategory")
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(name = "pages_count", nullable = false)
    private String pagesCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "author_type", nullable = false)
    private AuthorType authorType;

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
