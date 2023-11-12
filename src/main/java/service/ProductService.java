package service;

import entity.product.Product;

import java.util.Collection;

public interface ProductService {

    Collection<Product> findAll();
}
