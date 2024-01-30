package com.example.final_project.api.data.responce.admin;

import com.example.final_project.persistence.entity.order.OrderDetails;
import com.example.final_project.persistence.entity.order.OrderProducts;
import com.example.final_project.persistence.entity.product.ProductGenre;
import com.example.final_project.persistence.entity.product.ProductImage;
import com.example.final_project.persistence.type.GenreType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class AdminOrderData {
    private Long idDetails;
    private String city;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String postNumber;
    private boolean statusDetails;
    private String sum;
    private Long userId;
    private String username;

    private Long idProducts;
    private Long prodVarId;
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
    private boolean statusProducts;

    public AdminOrderData() {}

    public AdminOrderData(OrderDetails orderDetails, Collection<OrderProducts> orderProducts) {
        this.idDetails = orderDetails.getId();
        this.city = orderDetails.getCity();
        this.firstName = orderDetails.getFirstName();
        this.lastName = orderDetails.getLastName();
        this.phoneNumber = orderDetails.getPhoneNumber();
        this.postNumber = orderDetails.getPost();
        this.statusDetails = orderDetails.isStatus();
        this.sum = String.valueOf(orderDetails.getTotalSum());
        this.userId = orderDetails.getUser().getId();
        this.username = orderDetails.getUser().getUsername();

        if (orderProducts != null && !orderProducts.isEmpty()) {
            OrderProducts firstProduct = orderProducts.iterator().next();
            this.idProducts = firstProduct.getId();
            this.prodVarId = firstProduct.getProductVariant().getId();
            this.name = firstProduct.getProductVariant().getName();
            this.productAuthor = String.valueOf(firstProduct.getProductVariant().getProduct().getProductAuthor());
            this.description = firstProduct.getProductVariant().getDescription();
            this.pagesCount = firstProduct.getCount();
            this.year = firstProduct.getProductVariant().getYear();
            this.price = String.valueOf(firstProduct.getProductVariant().getPrice());
            this.language = String.valueOf(firstProduct.getProductVariant().getLanguage());
            Set<ProductImage> productImages = firstProduct.getProductVariant().getProductImages();
            if(CollectionUtils.isNotEmpty(productImages)) {
                this.images = productImages.stream().map(ProductImage::getImageUrl).collect(Collectors.toSet());
            }
            Set<ProductGenre> productGenres = firstProduct.getProductVariant().getProductGenres();
            if(CollectionUtils.isNotEmpty(productGenres)) {
                this.genreNameList = productGenres.stream()
                        .map(ProductGenre::getGenreName)
                        .distinct()
                        .map(GenreType::getGenre)
                        .collect(Collectors.toSet());
            }
            this.count = firstProduct.getCount();
            this.statusProducts = firstProduct.isStatus();
        }
    }
}
