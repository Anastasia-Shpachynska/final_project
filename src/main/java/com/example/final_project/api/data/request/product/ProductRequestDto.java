package com.example.final_project.api.data.request.product;

import com.example.final_project.api.data.request.RequestDto;
import com.example.final_project.persistence.type.AuthorType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto extends RequestDto {
    private String name;
    private String description;
    private AuthorType authorType;
}
