package com.example.final_project.persistence.repository.product;

import com.example.final_project.persistence.dto.product.ProductVariantMinDto;
import com.example.final_project.persistence.entity.product.Product;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.persistence.repository.BaseRepository;
import com.example.final_project.persistence.type.AuthorType;
import com.example.final_project.persistence.type.GenreType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductVariantRepository extends BaseRepository<ProductVariant> {

    Collection<ProductVariant> findAllByProduct(Product product);

    @Query(value = "select distinct new com.example.final_project.persistence.dto.product.ProductVariantMinDto(pv.product, pv.name, pv.id) from ProductVariant as pv")
    Collection<ProductVariantMinDto> findAllProductVariantMinDtoList();

    Collection<ProductVariant> findAllByProduct_ProductAuthor(AuthorType author);
}