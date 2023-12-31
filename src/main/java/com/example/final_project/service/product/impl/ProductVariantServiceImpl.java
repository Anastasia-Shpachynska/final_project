package com.example.final_project.service.product.impl;

import com.example.final_project.persistence.entity.product.Product;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.persistence.repository.product.ProductVariantRepository;
import com.example.final_project.persistence.type.AuthorType;
import com.example.final_project.persistence.type.GenreType;
import com.example.final_project.service.product.ProductVariantService;
import com.example.final_project.util.ExceptionUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

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
        isValidId(id);
        return productVariantRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.ENTITY_IS_NOT_PRESENT));
    }

    @Override
    public Collection<ProductVariant> findAll() {
        return productVariantRepository.findAll();
    }

    @Override
    public Collection<ProductVariant> findAllByProduct(Product product) {
        return productVariantRepository.findAllByProduct(product);
    }

    public Collection<ProductVariant> findAllByAuthor(AuthorType authorType) {
        return productVariantRepository.findAllByProduct_ProductAuthor(authorType);
    }

    private void isValidId(Long id) {
        if (id == null) {
            throw new EntityNotFoundException(ExceptionUtil.ENTITY_ID_IS_NOT_PRESENT);
        }
    }
}
