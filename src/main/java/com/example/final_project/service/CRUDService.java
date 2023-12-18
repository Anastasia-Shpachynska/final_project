package com.example.final_project.service;

import com.example.final_project.persistence.entity.BaseEntity;

import java.util.Collection;

public interface CRUDService <E extends BaseEntity> {

    void create(E entity);
    void update(E entity);
    E findById(Long id);
    Collection<E> findAll();
}
