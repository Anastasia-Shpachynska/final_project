package com.example.final_project.facade.admin.impl;

import com.example.final_project.api.data.responce.admin.AdminOrderData;
import com.example.final_project.facade.admin.AdminFacade;
import com.example.final_project.service.admin.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class AdminFacadeImpl implements AdminFacade {

    private final AdminService adminService;

    @Override
    public Collection<AdminOrderData> getOrder(Boolean status) {
        return adminService.getOrder(status);
    }

    @Override
    public AdminOrderData orderDetails(Long id) {
        return adminService.orderDetails(id);
    }

    @Override
    public void updateStatus(Long id) {
        adminService.updateStatus(id);
    }
}
