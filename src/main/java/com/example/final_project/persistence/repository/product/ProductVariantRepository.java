package com.example.final_project.persistence.repository.product;

import com.example.final_project.persistence.entity.product.Product;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductVariantRepository extends BaseRepository<ProductVariant> {

    Collection<ProductVariant> findAllByProduct(Product product);
}