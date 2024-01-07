package com.example.final_project.api.controller.open;

import com.example.final_project.api.data.responce.ResponseData;
import com.example.final_project.api.data.responce.product.ProductVariantData;
import com.example.final_project.facade.ProductPDPFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/open/productvariant")
public class ProductVariantController {

    private final ProductPDPFacade productPDPFacade;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseData<ProductVariantData>> findProductByIdAndLanguage(
            @PathVariable Long id,
            @RequestParam(name = "language", required = false) String language) {
        return ResponseEntity.ok(new ResponseData<>(productPDPFacade.findByIdAndLanguage(id, language)));
    }
}
