package com.example.final_project.api.controller.open;

import com.example.final_project.api.data.responce.ResponseData;
import com.example.final_project.api.data.responce.product.ProductPLPData;
import com.example.final_project.facade.ProductPLPFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/open/genre/{genreName}")
public class ProductPLPGenreController {

    private final ProductPLPFacade productPLPFacade;

    @GetMapping
    public ResponseEntity<ResponseData<Collection<ProductPLPData>>> getProductsByGenre(@PathVariable String genreName) {
        return ResponseEntity.ok(new ResponseData<>(productPLPFacade.getProductsByProductGenre(genreName)));
    }
}
