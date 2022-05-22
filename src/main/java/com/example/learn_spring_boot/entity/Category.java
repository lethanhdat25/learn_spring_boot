package com.example.learn_spring_boot.entity;

import com.example.learn_spring_boot.entity.baseEntity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Category extends BaseEntity {
    @Id
    public String id;
    public String name;

}