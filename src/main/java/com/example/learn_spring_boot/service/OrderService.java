package com.example.learn_spring_boot.service;

import com.example.learn_spring_boot.entity.Order;
import com.example.learn_spring_boot.repository.OrderRepository;
import com.example.learn_spring_boot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    public OrderRepository orderRepository;
    @Autowired
    public ProductRepository productRepository;

    public List<Order> findAll(){
        return  orderRepository.findAll();
    }
}
