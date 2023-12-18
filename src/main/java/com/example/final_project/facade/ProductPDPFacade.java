package com.example.final_project.facade;

import com.example.final_project.api.data.responce.product.ProductPDPData;

public interface ProductPDPFacade {
    ProductPDPData findById(Long id);
}
