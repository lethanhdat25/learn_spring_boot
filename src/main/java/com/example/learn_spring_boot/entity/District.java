package com.example.learn_spring_boot.entity;

import com.example.learn_spring_boot.entity.baseEntity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class District extends BaseEntity{
    @Id
    public String id;
    public String name;
}
