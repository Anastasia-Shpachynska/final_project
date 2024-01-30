package com.example.final_project.service.admin.impl;

import com.example.final_project.api.data.responce.admin.AdminOrderData;
import com.example.final_project.persistence.entity.order.OrderDetails;
import com.example.final_project.persistence.entity.order.OrderProducts;
import com.example.final_project.persistence.entity.user.User;
import com.example.final_project.persistence.repository.order.OrderDetailsRepository;
import com.example.final_project.persistence.repository.order.OrderProductsRepository;
import com.example.final_project.persistence.repository.user.PersonalRepository;
import com.example.final_project.service.admin.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final OrderDetailsRepository orderDetailsRepository;
    private final OrderProductsRepository orderProductsRepository;

    @Override
    public Collection<AdminOrderData> getOrder(Boolean status) {
        Collection<AdminOrderData> adminOrderDataList = new ArrayList<>();
        Collection<OrderDetails> orderDetails = orderDetailsRepository.findAllByStatusOrderByIdDesc(status);
        for (OrderDetails orderDetail : orderDetails) {
            Collection<OrderProducts> orderProducts = orderProductsRepository.findAllByStatusAndUser(status, orderDetail.getUser());

            AdminOrderData adminOrderData = new AdminOrderData(orderDetail, orderProducts);
            adminOrderDataList.add(adminOrderData);
        }
        return adminOrderDataList;
    }

    @Override
    public AdminOrderData orderDetails(Long id) {
        OrderDetails orderDetails = orderDetailsRepository.findOrderDetailsById(id);
        User user = orderDetails.getUser();
        Collection<OrderProducts> orderProducts = orderProductsRepository.findAllByUser(user);

        AdminOrderData adminOrderData = new AdminOrderData(orderDetails, orderProducts);
        return adminOrderData;
    }

    @Override
    public void updateStatus(Long id) {
        OrderDetails orderDetails = orderDetailsRepository.findOrderDetailsById(id);
        if (orderDetails != null) {
            orderDetails.setStatus(true);

            User user = orderDetails.getUser();
            if (user != null) {
                Collection<OrderProducts> orderProducts = orderProductsRepository.findAllByUser(user);

                for (OrderProducts orderProduct : orderProducts) {
                    orderProduct.setStatus(true);
                }

                orderDetailsRepository.save(orderDetails);
                orderProductsRepository.saveAll(orderProducts);
            }
        }
    }
}
