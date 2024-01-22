package com.example.final_project.service.product.impl;

import com.example.final_project.api.data.responce.product.ProductPDPData;
import com.example.final_project.api.data.responce.product.ProductVariantData;
import com.example.final_project.persistence.entity.product.Product;
import com.example.final_project.persistence.entity.product.ProductGenre;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.persistence.repository.product.ProductGenreRepository;
import com.example.final_project.persistence.repository.product.ProductVariantRepository;
import com.example.final_project.persistence.type.AuthorType;
import com.example.final_project.persistence.type.GenreType;
import com.example.final_project.persistence.type.LanguageType;
import com.example.final_project.service.product.ProductVariantService;
import com.example.final_project.util.ExceptionUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
@AllArgsConstructor
public class ProductVariantServiceImpl implements ProductVariantService {

    private ProductVariantRepository productVariantRepository;
    private ProductGenreRepository productGenreRepository;

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

    public Collection<ProductVariant> findAllByGenre(String genre) {
        Collection<ProductVariant> productVariants = null;
        Collection<ProductGenre> productGenres = productGenreRepository.findAll();
        for (ProductGenre productGenre : productGenres) {
            if(productGenre.getGenreName().getGenre().equals(genre)) {
                productVariants = productVariantRepository.findAllByProductGenres(productGenre);
            }
        }
        return productVariants;
    }

    public ProductVariant findByIdAndLanguage(Long id, String language) {
        Collection<ProductVariant> productVariants = findAll();
        Set<LanguageType> languageTypeSet = new HashSet<>();
        ProductVariant product = null;
        for (ProductVariant productVariant : productVariants) {
            languageTypeSet.addAll(Collections.singleton(productVariant.getLanguage()));
        }
        for (LanguageType languageType : languageTypeSet) {
            if(languageType.getLanguage().equals(language)) {
                product = productVariantRepository.findProductVariantWhereProductIdAndLanguage(id, languageType);
            }
        }
        return product;
    }

    private void isValidId(Long id) {
        if (id == null) {
            throw new EntityNotFoundException(ExceptionUtil.ENTITY_ID_IS_NOT_PRESENT);
        }
    }
}
