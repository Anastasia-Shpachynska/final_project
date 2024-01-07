package com.example.final_project.service.product;

import com.example.final_project.persistence.entity.product.Product;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.persistence.type.AuthorType;
import com.example.final_project.service.CRUDService;

import java.util.Collection;

public interface ProductVariantService extends CRUDService<ProductVariant> {
    Collection<ProductVariant> findAllByProduct(Product product);
    Collection<ProductVariant> findAllByAuthor(AuthorType authorType);

    Collection<ProductVariant> findAllByGenre(String genre);

    ProductVariant findByIdAndLanguage(Long id, String language);
}
