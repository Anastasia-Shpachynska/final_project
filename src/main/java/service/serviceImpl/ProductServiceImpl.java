package service.serviceImpl;

import entity.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repo.product.ProductRepository;
import service.ProductService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Collection<Product> findAll() {
        return productRepository.findAll();
    }
}
