package data.responce;

import entity.product.Product;
import entity.product.ProductImage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Set;

@Getter
@Setter
public class ProductData {

    private Long id;
    private String author;
    private String name;
    private String image;
//    private String price;

    public ProductData(Product product) {
        this.id = product.getId();
        this.author = product.getProductAuthor().getAuthor();
        this.name = product.getName();
        Set<ProductImage> productImages = product.getProductImages();
        if(CollectionUtils.isEmpty(productImages)) {
             ProductImage productImage = productImages
                     .stream()
                     .filter(ProductImage::getMainImage)
                     .findFirst().orElse(new ArrayList<>(productImages).get(0));
             this.image = productImage.getImageUrl();
        }
    }
}
