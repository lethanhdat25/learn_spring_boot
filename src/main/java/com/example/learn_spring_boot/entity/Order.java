package com.example.learn_spring_boot.entity;

import com.example.learn_spring_boot.entity.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    public String id;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "order",cascade = CascadeType.ALL)
    public Set<OrderDetail> orderDetails;
    public BigDecimal totalPrice;
    public String shipName;
    public String shipAddress;
    public String shipPhone;
    public String shipNote;
    @Enumerated(EnumType.ORDINAL)
    public OrderStatus status;
}
