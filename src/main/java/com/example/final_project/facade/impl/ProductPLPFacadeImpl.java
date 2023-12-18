package com.example.final_project.facade.impl;

import com.example.final_project.api.data.responce.product.ProductPLPData;
import com.example.final_project.facade.ProductPLPFacade;
import com.example.final_project.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductPLPFacadeImpl implements ProductPLPFacade {

    private final ProductService productService;

    @Override
    public Collection<ProductPLPData> getProducts() {
        return productService.findAll().stream().map(ProductPLPData::new).toList();
    }
}
