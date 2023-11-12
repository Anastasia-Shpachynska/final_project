package controller;


import data.responce.ProductData;
import data.responce.ResponseData;
import fasade.ProductFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/open/products")
public class ProductsController {

    private final ProductFacade productFacade;

    @GetMapping
    public ResponseEntity<ResponseData<Collection<ProductData>>> getProducts() {
        return ResponseEntity.ok(new ResponseData<>(productFacade.getProducts()));
    }
}


