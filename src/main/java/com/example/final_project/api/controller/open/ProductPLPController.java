package com.example.final_project.api.controller.open;

import com.example.final_project.api.data.responce.ProductPLPData;
import com.example.final_project.api.data.responce.ResponseData;
import com.example.final_project.facade.ProductPLPFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/open/products")
public class ProductPLPController {

    private final ProductPLPFacade productPLPFacade;

    @GetMapping
    public ResponseEntity<ResponseData<Collection<ProductPLPData>>> getProducts() {
        return ResponseEntity.ok(new ResponseData<>(productPLPFacade.getProducts()));
    }
}
