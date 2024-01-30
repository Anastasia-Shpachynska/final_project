package com.example.final_project.persistence.repository.order;

import com.example.final_project.persistence.entity.order.OrderProducts;
import com.example.final_project.persistence.entity.user.User;
import com.example.final_project.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface OrderProductsRepository extends BaseRepository<OrderProducts> {
    Collection<OrderProducts> findAllByStatusAndUser(Boolean status, User user);

    Collection<OrderProducts> findAllByUser(User user);
}
