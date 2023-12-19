package com.example.final_project.api.data.responce.product;

import com.example.final_project.persistence.entity.product.ProductImage;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.persistence.type.GenreType;
import com.example.final_project.persistence.type.LanguageType;
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
    private String year;
    private String price;
    private Set<String> images;
    private Set<String> languageList;
    private Set<String> genreNameList;

    public ProductPDPData(ProductVariant productVariant, Collection<ProductVariant> variants) {
        this.id = productVariant.getId();
        this.productAuthor = productVariant.getProduct().getProductAuthor().getAuthor();
        this.pagesCount = String.valueOf(productVariant.getProduct().getPagesCount());
        this.name = productVariant.getName();
        this.year = String.valueOf(productVariant.getYear());
        this.description = productVariant.getDescription();
        this.price = String.valueOf(productVariant.getPrice());
        Set<ProductImage> productImages = productVariant.getProductImages();
        if(CollectionUtils.isNotEmpty(productImages)) {
            this.images = productImages.stream().map(ProductImage::getImageUrl).collect(Collectors.toSet());
        }
        if(CollectionUtils.isNotEmpty(variants)) {
            this.languageList = variants.stream().map(ProductVariant::getLanguage).map(LanguageType::getLanguage).collect(Collectors.toSet());
            this.genreNameList = variants.stream().map(ProductVariant::getProductGenres).flatMap(Set::stream).map(productGenre -> productGenre.getGenreName().getGenre()).collect(Collectors.toSet());
        }
    }
}
