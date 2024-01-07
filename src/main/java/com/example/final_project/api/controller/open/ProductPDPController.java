package com.example.final_project.api.controller.open;

import com.example.final_project.api.data.responce.product.ProductPDPData;
import com.example.final_project.api.data.responce.ResponseData;
import com.example.final_project.facade.ProductPDPFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/open/products/{id}")
public class ProductPDPController {

    private final ProductPDPFacade productPDPFacade;

    @GetMapping
    public ResponseEntity<ResponseData<ProductPDPData>> findProduct(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseData<>(productPDPFacade.findById(id)));
    }
}
