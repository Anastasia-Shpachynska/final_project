package com.example.final_project.facade;

import com.example.final_project.api.data.request.product.ProductRequestDto;
import com.example.final_project.api.data.responce.product.ProductResponseDto;

public interface ProductFacade extends CRUDFacade<ProductRequestDto, ProductResponseDto>{
}
