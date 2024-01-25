package com.example.final_project.api.data.responce.cart;

import com.example.final_project.persistence.entity.cart.Cart;
import com.example.final_project.persistence.entity.product.ProductGenre;
import com.example.final_project.persistence.entity.product.ProductImage;
import com.example.final_project.persistence.type.GenreType;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class CartData {
    private Long id;
    private String name;
    private String productAuthor;
    private String description;
    private int pagesCount;
    private int year;
    private String price;
    private String language;
    private Set<String> images;
    private Set<String> genreNameList;
    private int count;
    private Long userId;
    private String username;

    public CartData() {
        // Порожній конструктор за замовчуванням
    }

    public CartData(Cart cart) {
        this.id = cart.getProductVariant().getId();
        this.productAuthor = cart.getProductVariant().getProduct().getProductAuthor().getAuthor();
        this.pagesCount = cart.getProductVariant().getProduct().getPagesCount();
        this.name = cart.getProductVariant().getName();
        this.year = cart.getProductVariant().getYear();
        this.description = cart.getProductVariant().getDescription();
        this.price = String.valueOf(cart.getProductVariant().getPrice());
        this.language = cart.getProductVariant().getLanguage().getLanguage();
        this.userId = cart.getUser().getId();
        this.username = cart.getUser().getUsername();
        this.count = cart.getCount();
        Set<ProductImage> productImages = cart.getProductVariant().getProductImages();
        if(CollectionUtils.isNotEmpty(productImages)) {
            this.images = productImages.stream().map(ProductImage::getImageUrl).collect(Collectors.toSet());
        }
        Set<ProductGenre> productGenres = cart.getProductVariant().getProductGenres();
        if(CollectionUtils.isNotEmpty(productGenres)) {
            this.genreNameList = productGenres.stream().map(ProductGenre::getGenreName).map(GenreType::getGenre).collect(Collectors.toSet());
        }
    }
}
