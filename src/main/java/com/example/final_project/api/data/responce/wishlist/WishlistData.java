package com.example.final_project.api.data.responce.wishlist;

import com.example.final_project.persistence.entity.product.ProductGenre;
import com.example.final_project.persistence.entity.product.ProductImage;
import com.example.final_project.persistence.entity.wishlist.Wishlist;
import com.example.final_project.persistence.type.GenreType;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class WishlistData {
    private Long productVarId;
    private String name;
    private String productAuthor;
    private String description;
    private int pagesCount;
    private int year;
    private String price;
    private String language;
    private Long productId;
    private Set<String> images;
    private Set<String> genreNameList;

    public WishlistData() {
    }

    public WishlistData(Wishlist wishlist) {
        this.productVarId = wishlist.getProductVariant().getId();
        this.productAuthor = wishlist.getProductVariant().getProduct().getProductAuthor().getAuthor();
        this.pagesCount = wishlist.getProductVariant().getProduct().getPagesCount();
        this.name = wishlist.getProductVariant().getName();
        this.year = wishlist.getProductVariant().getYear();
        this.description = wishlist.getProductVariant().getDescription();
        this.price = String.valueOf(wishlist.getProductVariant().getPrice());
        this.language = wishlist.getProductVariant().getLanguage().getLanguage();
        this.productId = wishlist.getProductVariant().getProduct().getId();
        Set<ProductImage> productImages = wishlist.getProductVariant().getProductImages();
        if(CollectionUtils.isNotEmpty(productImages)) {
            this.images = productImages.stream().map(ProductImage::getImageUrl).collect(Collectors.toSet());
        }
        Set<ProductGenre> productGenres = wishlist.getProductVariant().getProductGenres();
        if(CollectionUtils.isNotEmpty(productGenres)) {
            this.genreNameList = productGenres.stream().map(ProductGenre::getGenreName).map(GenreType::getGenre).collect(Collectors.toSet());
        }
    }
}
