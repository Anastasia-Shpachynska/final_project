package entity.product;

import entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name= "product_images")
public class ProductImage extends BaseEntity{

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "main_image", nullable = false)
    private Boolean mainImage;

    @ManyToMany(mappedBy = "productImages")
    private Set<Product> products;

    public ProductImage() {
        super();
        this.products = new HashSet<>();
        this.mainImage = false;
    }
}
