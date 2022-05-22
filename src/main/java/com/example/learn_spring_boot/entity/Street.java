package com.example.learn_spring_boot.entity;

import com.example.learn_spring_boot.entity.baseEntity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Street extends BaseEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String id;
    public String name;
    public String district_id;
    @ManyToOne
    @JoinColumn(name = "district_id",insertable = false, updatable = false)
    public District district;
}
