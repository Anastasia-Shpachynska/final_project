package com.example.final_project.service.admin;

import com.example.final_project.api.data.responce.admin.AdminOrderData;

import java.util.Collection;

public interface AdminService {
    Collection<AdminOrderData> getOrder(Boolean status);
    AdminOrderData orderDetails(Long id);
    void updateStatus(Long id);
}
