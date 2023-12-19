package com.example.final_project.service.product;

import com.example.final_project.persistence.entity.product.Product;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.service.CRUDService;

import java.util.Collection;

public interface ProductService extends CRUDService<Product> {

    Collection<Product> findAll();
}
