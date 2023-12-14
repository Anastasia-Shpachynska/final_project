package com.example.final_project.api.data.responce;

import com.example.final_project.persistence.entity.product.Product;
import com.example.final_project.persistence.entity.product.ProductImage;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Set;

@Getter
@Setter
public class ProductPLPData {

    private Long id;
    private String author;
    private String name;
    private String image;
//    private String price;

    public ProductPLPData(Product product) {
        this.id = product.getId();
        this.author = product.getProductAuthor().getAuthor();
        this.name = product.getName();
        Set<ProductImage> productImages = product.getProductImages();
        if(CollectionUtils.isNotEmpty(productImages)) {
            ProductImage productImage = productImages
                    .stream()
                    .filter(ProductImage::getMainImage)
                    .findFirst()
                    .orElse(new ArrayList<>(productImages).get(0));
            this.image = productImage.getImageUrl();
//            this.price = String.valueOf(productVariant.getPrice());
        }
    }
}
