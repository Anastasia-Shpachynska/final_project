package com.example.final_project.api.controller.open;

import com.example.final_project.api.data.responce.ResponseData;
import com.example.final_project.elastic.document.ProductIndex;
import com.example.final_project.service.search.ProductSearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/api/open/products/search")
public class ProductSearchController {

    private final ProductSearchService productSearchService;

    @GetMapping
    public ResponseEntity<ResponseData<Collection<ProductIndex>>> search(@RequestParam String query) {
       return ResponseEntity.ok(new ResponseData<>(productSearchService.search(query)));
    }
}
