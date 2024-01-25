package com.example.final_project.persistence.entity.order;

import com.example.final_project.persistence.entity.BaseEntity;
import com.example.final_project.persistence.entity.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table
@Getter
@Setter
public class OrderDetails extends BaseEntity {
    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String post;

    @Column(nullable = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal totalSum;

    @Column(nullable = false)
    private boolean status;
}
