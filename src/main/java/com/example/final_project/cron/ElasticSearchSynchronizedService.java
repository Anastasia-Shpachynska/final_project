package com.example.final_project.cron;

import com.example.final_project.elastic.document.ProductIndex;
import com.example.final_project.elastic.repository.ProductIndexRepository;
import com.example.final_project.persistence.dto.product.ProductVariantMinDto;
import com.example.final_project.persistence.entity.product.Product;
import com.example.final_project.persistence.entity.product.ProductVariant;
import com.example.final_project.persistence.repository.product.ProductVariantRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class ElasticSearchSynchronizedService {

    private final ProductIndexRepository productIndexRepository;
    private final ElasticsearchOperations elasticsearchOperations;
    private final ProductVariantRepository productVariantRepository;

//    @Scheduled(cron = "*/10 * * * * *")
    public void synchronizedDocuments() {
        System.out.println("start");
        elasticsearchOperations.indexOps(ProductIndex.class).refresh();
        productIndexRepository.deleteAll();
        productIndexRepository.saveAll(generateProductIndices());
        System.out.println("finish");
    }

    private Collection<ProductIndex> generateProductIndices() {
        Collection<ProductVariantMinDto> productVariants = productVariantRepository.findAllProductVariantMinDtoList();
        List<ProductIndex> productIndices = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(productVariants)) {
            productIndices = productVariants
                    .stream()
                    .map(pv -> {
                        ProductIndex productIndex = new ProductIndex();
                        StringBuilder sb = new StringBuilder();
                        Product product = pv.product();
                        if(product != null) {
                            sb.append(pv.name());
                            sb.append(", ");
                            sb.append(product.getProductAuthor());
                            productIndex.setPId(product.getId());
                        }
                        productIndex.setProductInfo(sb.toString());
                        productIndex.setPvId(pv.pvId());
                        return productIndex;
                    })
                    .toList();
        }
        return productIndices;
    }
}
