package com.example.learn_spring_boot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderDetailId implements Serializable {
    @Column(name = "productId")
    private String productId;
    @Column(name = "orderId")
    private String orderId;
}
