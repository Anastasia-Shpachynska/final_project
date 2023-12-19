package com.example.final_project.api.data.responce.product;

import com.example.final_project.api.data.responce.ResponseDto;
import com.example.final_project.persistence.entity.product.Product;
import com.example.final_project.persistence.type.AuthorType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto extends ResponseDto {
    private int pageCount;
    private AuthorType authorType;

    public ProductResponseDto(Product product) {
        super.setId(product.getId());
        this.pageCount = product.getPagesCount();
        this.authorType = product.getProductAuthor();
    }
}
