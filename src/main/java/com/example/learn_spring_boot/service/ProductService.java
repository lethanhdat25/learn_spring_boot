package com.example.learn_spring_boot.service;

import com.example.learn_spring_boot.entity.Product;
import com.example.learn_spring_boot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    public ProductRepository productRepository;

    public Page<Product> findAll(int page,int limit){
        return productRepository.findAll(PageRequest.of(page,limit));
    }

    public Optional<Product> findById(String id){
        return productRepository.findById(id);
    }

    public Product save(Product product){
        return  productRepository.save(product);
    }

    public void delete(String id){
        productRepository.deleteById(id);
    }
}
