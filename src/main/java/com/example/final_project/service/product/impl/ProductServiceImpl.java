package com.example.final_project.service.product.impl;

import com.example.final_project.persistence.entity.product.Product;
import com.example.final_project.persistence.repository.product.ProductRepository;
import com.example.final_project.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Collection<Product> findAll() {
        return productRepository.findAll();
    }
}
