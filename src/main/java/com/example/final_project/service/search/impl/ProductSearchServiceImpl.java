package com.example.final_project.service.search.impl;

import com.example.final_project.elastic.document.ProductIndex;
import com.example.final_project.elastic.repository.ProductIndexRepository;
import com.example.final_project.service.search.ProductSearchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductSearchServiceImpl implements ProductSearchService {

    private final ProductIndexRepository productIndexRepository;

    @Override
    public Collection<ProductIndex> search(String query) {
        return productIndexRepository.findFirst10ByProductInfoContainingIgnoreCase(query);
    }
}
