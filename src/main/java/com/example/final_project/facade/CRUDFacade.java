package com.example.final_project.facade;

import com.example.final_project.api.data.request.RequestDto;
import com.example.final_project.api.data.responce.ResponseDto;
import com.example.final_project.persistence.type.AuthorType;

import java.util.Collection;

public interface CRUDFacade<REQUEST extends RequestDto, RESPONSE extends ResponseDto> {
    void create(REQUEST request);
    void update(REQUEST request, Long id);
    RESPONSE findById(Long id);
    Collection<RESPONSE> findAll();
}
