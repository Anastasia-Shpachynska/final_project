package com.example.final_project.facade;

import com.example.final_project.api.data.responce.ProductPLPData;

import java.util.Collection;

public interface ProductPLPFacade {

    Collection<ProductPLPData> getProducts();
}
