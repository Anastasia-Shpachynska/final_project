package com.example.final_project.api.data.responce.product;

import com.example.final_project.persistence.entity.product.ProductImage;
import com.example.final_project.persistence.entity.product.ProductVariant;
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
    private String price;

    public ProductPLPData(ProductVariant productVariant) {
        this.id = productVariant.getId();
        this.author = productVariant.getProduct().getProductAuthor().getAuthor();
        this.name = productVariant.getName();
        Set<ProductImage> productImages = productVariant.getProductImages();
        if(CollectionUtils.isNotEmpty(productImages)) {
            ProductImage productImage = productImages
                    .stream()
                    .filter(ProductImage::getMainImage)
                    .findFirst()
                    .orElse(new ArrayList<>(productImages).get(0));
            this.image = productImage.getImageUrl();
            this.price = String.valueOf(productVariant.getPrice());
        }
    }
}
