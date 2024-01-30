package com.example.final_project.facade.admin;

import com.example.final_project.api.data.responce.admin.AdminOrderData;

import java.util.Collection;

public interface AdminFacade {
    Collection<AdminOrderData> getOrder(Boolean status);
    AdminOrderData orderDetails(Long id);
    void updateStatus(Long id);
}
