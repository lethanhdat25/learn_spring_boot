package com.example.learn_spring_boot.entity;

import com.example.learn_spring_boot.entity.baseEntity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product extends BaseEntity {
    @Id
    public String id;
    public String name;
    public BigDecimal price;
    public String category_id;
    @ManyToOne
    @JoinColumn(name = "category_id",insertable = false,updatable = false)
    public Category category;
}
