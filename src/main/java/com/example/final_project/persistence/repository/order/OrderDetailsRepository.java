package com.example.final_project.persistence.repository.order;

import com.example.final_project.persistence.entity.order.OrderDetails;
import com.example.final_project.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface OrderDetailsRepository extends BaseRepository<OrderDetails> {
    Collection<OrderDetails> findAllByStatusOrderByIdDesc(Boolean status);

    OrderDetails findOrderDetailsById(Long id);
}
