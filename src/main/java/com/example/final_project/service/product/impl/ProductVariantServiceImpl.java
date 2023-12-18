package com.example.final_project.service.product.impl;

import com.example.final_project.persistence.entity.product.Product;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.persistence.repository.product.ProductVariantRepository;
import com.example.final_project.service.product.ProductVariantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@AllArgsConstructor
public class ProductVariantServiceImpl implements ProductVariantService {

    private ProductVariantRepository productVariantRepository;

    @Override
    public void create(ProductVariant entity) {

    }

    @Override
    public void update(ProductVariant entity) {

    }

    @Override
    public ProductVariant findById(Long id) {
        return null;
    }

    @Override
    public Collection<ProductVariant> findAll() {
        return null;
    }

    @Override
    public Collection<ProductVariant> findAllByProduct(Product product) {
        return productVariantRepository.findAllByProduct(product);
    }
}
