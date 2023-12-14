package com.example.final_project.service.product;

import com.example.final_project.persistence.entity.product.Product;

import java.util.Collection;

public interface ProductService {

    Collection<Product> findAll();
}
