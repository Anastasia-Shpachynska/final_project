package com.example.final_project.persistence.dto.product;

import com.example.final_project.persistence.entity.product.Product;
import com.example.final_project.persistence.entity.product.ProductVariant;

public record ProductVariantMinDto(Product product, String name, Long pvId) {
}
