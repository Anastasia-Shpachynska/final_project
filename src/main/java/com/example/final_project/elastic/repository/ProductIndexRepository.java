package com.example.final_project.elastic.repository;

import com.example.final_project.elastic.document.ProductIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductIndexRepository extends ElasticsearchRepository<ProductIndex, String> {

    List<ProductIndex> findFirst10ByProductInfoContainingIgnoreCase(String query);
}
