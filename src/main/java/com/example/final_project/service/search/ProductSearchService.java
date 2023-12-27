package com.example.final_project.service.search;

import com.example.final_project.elastic.document.ProductIndex;

import java.util.Collection;

public interface ProductSearchService {

    Collection<ProductIndex> search(String query);
}
