package com.example.final_project.api.data.responce.product;

import com.example.final_project.persistence.entity.product.Product;
import com.example.final_project.persistence.entity.product.ProductImage;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.persistence.type.AuthorType;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProductPDPData {

    private Long id;
    private String name;
    private String productAuthor;
    private String description;
    private String pagesCount;
    private Set<String> images;
    private Set<String> languageList;

    public ProductPDPData(Product product, Collection<ProductVariant> variants) {
        this.id = product.getId();
        this.name = product.getName();
        this.productAuthor = product.getProductAuthor().getAuthor();
        this.description = product.getDescription();
        this.pagesCount = String.valueOf(product.getPagesCount());
        Set<ProductImage> productImages = product.getProductImages();
        if(CollectionUtils.isNotEmpty(productImages)) {
            this.images = productImages.stream().map(ProductImage::getImageUrl).collect(Collectors.toSet());
        }
        if(CollectionUtils.isNotEmpty(variants)) {
            this.languageList = variants.stream().map(ProductVariant::getLanguage).collect(Collectors.toSet());
        }
    }
}
