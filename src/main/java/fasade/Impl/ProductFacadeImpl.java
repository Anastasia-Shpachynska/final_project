package fasade.Impl;

import data.responce.ProductData;
import fasade.ProductFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import service.ProductService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductFacadeImpl implements ProductFacade {

private final ProductService productService;

    @Override
    public Collection<ProductData> getProducts() {
        return productService.findAll().stream().map(ProductData::new).toList();
    }
}
