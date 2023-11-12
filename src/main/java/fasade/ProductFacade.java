package fasade;

import data.responce.ProductData;

import java.util.Collection;

public interface ProductFacade {

    Collection<ProductData> getProducts();
}
