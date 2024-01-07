package com.example.final_project.api.data.responce.product;

import com.example.final_project.persistence.entity.product.ProductGenre;
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
public class ProductVariantData {
    private Long id;
    private String name;
    private String productAuthor;
    private String description;
    private String pagesCount;
    private String year;
    private String price;
    private String language;
    private Set<String> images;
    private Set<String> genreNameList;

    public ProductVariantData(ProductVariant productVariant, Collection<ProductVariant> variants) {
        this.id = productVariant.getId();
        this.productAuthor = productVariant.getProduct().getProductAuthor().getAuthor();
        this.pagesCount = String.valueOf(productVariant.getProduct().getPagesCount());
        this.name = productVariant.getName();
        this.year = String.valueOf(productVariant.getYear());
        this.description = productVariant.getDescription();
        this.price = String.valueOf(productVariant.getPrice());
        this.language = productVariant.getLanguage().getLanguage();
        Set<ProductImage> productImages = productVariant.getProductImages();
        if(CollectionUtils.isNotEmpty(productImages)) {
            this.images = productImages.stream().map(ProductImage::getImageUrl).collect(Collectors.toSet());
        }
        Set<ProductGenre> productGenres = variants.stream()
                .flatMap(productVariant1 -> productVariant.getProductGenres().stream())
                .collect(Collectors.toSet());
        if(CollectionUtils.isNotEmpty(productGenres)) {
            this.genreNameList = productGenres.stream().map(ProductGenre::getGenreName).map(GenreType::getGenre).collect(Collectors.toSet());
        }
    }
}
