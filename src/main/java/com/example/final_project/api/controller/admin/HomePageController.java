package com.example.final_project.api.controller.admin;

import com.example.final_project.api.data.responce.ResponseData;
import com.example.final_project.api.data.responce.admin.AdminOrderData;
import com.example.final_project.facade.admin.AdminFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/private/admin")
public class HomePageController {

    private final AdminFacade adminFacade;

    @GetMapping("/order/{status}")
    public ResponseEntity<ResponseData<Collection<AdminOrderData>>> getOrder(@PathVariable(name = "status") Boolean status) {
        try {
            return ResponseEntity.ok(new ResponseData<>(adminFacade.getOrder(status)));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/detailsOrder/{id}")
    public ResponseEntity<ResponseData<AdminOrderData>> orderDetails(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(new ResponseData<>(adminFacade.orderDetails(id)));
    }

    @PostMapping("/updateStatus/{id}")
    public void updateStatus(@PathVariable(name = "id") Long id) {
        adminFacade.updateStatus(id);
    }
}
