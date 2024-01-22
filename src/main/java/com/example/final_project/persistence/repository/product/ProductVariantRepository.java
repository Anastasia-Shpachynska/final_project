package com.example.final_project.persistence.repository.product;

import com.example.final_project.persistence.dto.product.ProductVariantMinDto;
import com.example.final_project.persistence.entity.product.Product;
import com.example.final_project.persistence.entity.product.ProductGenre;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.persistence.repository.BaseRepository;
import com.example.final_project.persistence.type.AuthorType;
import com.example.final_project.persistence.type.GenreType;
import com.example.final_project.persistence.type.LanguageType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductVariantRepository extends BaseRepository<ProductVariant> {

    Collection<ProductVariant> findAllByProduct(Product product);

    @Query(value = "select distinct new com.example.final_project.persistence.dto.product.ProductVariantMinDto(pv.product, pv.name, pv.id) from ProductVariant as pv")
    Collection<ProductVariantMinDto> findAllProductVariantMinDtoList();

    Collection<ProductVariant> findAllByProduct_ProductAuthor(AuthorType author);

    Collection<ProductVariant> findAllByProductGenres(ProductGenre productGenre);

    @Query("SELECT pv FROM ProductVariant pv WHERE pv.product.id = :id AND pv.language = :language")
    ProductVariant findProductVariantWhereProductIdAndLanguage(@Param("id") Long id, @Param("language") LanguageType language);

    ProductVariant findProductVariantById(Long id);
}