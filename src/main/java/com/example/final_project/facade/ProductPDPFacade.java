package com.example.final_project.facade;

import com.example.final_project.api.data.responce.product.ProductPDPData;
import com.example.final_project.api.data.responce.product.ProductVariantData;

public interface ProductPDPFacade {
    ProductPDPData findById(Long id);

    ProductVariantData findByIdAndLanguage(Long id, String language);
}
