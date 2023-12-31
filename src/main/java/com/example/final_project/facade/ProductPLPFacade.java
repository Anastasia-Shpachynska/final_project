package com.example.final_project.facade;

import com.example.final_project.api.data.responce.product.ProductPLPData;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.persistence.type.AuthorType;

import java.util.Collection;

public interface ProductPLPFacade {

    Collection<ProductPLPData> getProducts();

    Collection<ProductPLPData> getProductsByAuthor(AuthorType author);

    Collection<ProductPLPData> getProductsByProductGenre(String genre);
}
