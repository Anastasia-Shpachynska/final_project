package com.example.final_project.facade.impl;

import com.example.final_project.api.data.responce.product.ProductPDPData;
import com.example.final_project.api.data.responce.product.ProductVariantData;
import com.example.final_project.facade.ProductPDPFacade;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.service.product.ProductService;
import com.example.final_project.service.product.ProductVariantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductPDPFacadeImpl implements ProductPDPFacade {

    private final ProductVariantService productVariantService;

    @Override
    public ProductPDPData findById(Long id) {
        ProductVariant productVariant = productVariantService.findById(id);
        Collection<ProductVariant> productVariants = productVariantService.findAllByProduct(productVariant.product);
        return new ProductPDPData(productVariant, productVariants);
    }

    @Override
    public ProductVariantData findByIdAndLanguage(Long id, String language) {
       ProductVariant productVariant = productVariantService.findByIdAndLanguage(id, language);
        Collection<ProductVariant> productVariants = productVariantService.findAllByProduct(productVariant.product);
        return new ProductVariantData(productVariant, productVariants);
    }
}
