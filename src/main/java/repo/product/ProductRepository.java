package repo.product;

import entity.product.Product;
import org.springframework.stereotype.Repository;
import repo.BaseRepository;

@Repository
public interface ProductRepository extends BaseRepository<Product> {

}
