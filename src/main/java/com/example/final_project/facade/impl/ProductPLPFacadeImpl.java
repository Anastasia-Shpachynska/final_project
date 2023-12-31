package com.example.final_project.facade.impl;

import com.example.final_project.api.data.responce.product.ProductPLPData;
import com.example.final_project.facade.ProductPLPFacade;
import com.example.final_project.persistence.entity.product.Product;
import com.example.final_project.persistence.type.AuthorType;
import com.example.final_project.service.product.ProductService;
import com.example.final_project.service.product.ProductVariantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductPLPFacadeImpl implements ProductPLPFacade {

    private final ProductVariantService productVariantService;

    @Override
    public Collection<ProductPLPData> getProducts() {
        return productVariantService.findAll().stream().map(ProductPLPData::new).toList();
    }

    @Override
    public Collection<ProductPLPData> getProductsByAuthor(AuthorType author) {
        return productVariantService.findAllByAuthor(author).stream().map(ProductPLPData::new).toList();
    }


}
