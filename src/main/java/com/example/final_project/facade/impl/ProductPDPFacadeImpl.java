package com.example.final_project.facade.impl;

import com.example.final_project.api.data.responce.product.ProductPDPData;
import com.example.final_project.facade.ProductPDPFacade;
import com.example.final_project.persistence.entity.product.Product;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.service.product.ProductService;
import com.example.final_project.service.product.ProductVariantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductPDPFacadeImpl implements ProductPDPFacade {

    private final ProductService productService;
    private final ProductVariantService productVariantService;

    @Override
    public ProductPDPData findById(Long id) {
        Product product = productService.findById(id);
        Collection<ProductVariant> productVariants = productVariantService.findAllByProduct(product);
        return new ProductPDPData(product, productVariants);
    }
}
