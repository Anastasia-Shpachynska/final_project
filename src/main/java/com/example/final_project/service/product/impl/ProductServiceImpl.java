package com.example.final_project.service.product.impl;

import com.example.final_project.exception.NotValidDataException;
import com.example.final_project.persistence.entity.product.Product;
import com.example.final_project.persistence.repository.product.ProductRepository;
import com.example.final_project.service.product.ProductService;
import com.example.final_project.util.ExceptionUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void create(Product entity) {
        isValidProduct(entity);
        productRepository.save(entity);
    }

    @Override
    public void update(Product entity) {
        isValidProduct(entity);
        isValidId(entity.getId());
        productRepository.save(entity);
    }

    @Override
    public Product findById(Long id) {
        isValidId(id);
        return productRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.ENTITY_IS_NOT_PRESENT));
    }

    @Override
    public Collection<Product> findAll() {
        return productRepository.findAll();
    }

    private void isValidProduct(Product product) {
        if (product == null) {
            throw new NotValidDataException(ExceptionUtil.PRODUCT_IS_NOT_PRESENT);
        }
        if (product.getName() == null) {
            throw new NotValidDataException(ExceptionUtil.PRODUCT_NAME_IS_NOT_PRESENT);
        }
        if (product.getProductAuthor() == null) {
            throw new NotValidDataException(ExceptionUtil.PRODUCT_AUTHOR_IS_NOT_PRESENT);
        }
    }

    private void isValidId(Long id) {
        if (id == null) {
            throw new EntityNotFoundException(ExceptionUtil.ENTITY_ID_IS_NOT_PRESENT);
        }
    }
}
