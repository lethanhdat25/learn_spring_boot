package com.example.learn_spring_boot.repository;

import com.example.learn_spring_boot.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    Page<Product> findAll(Pageable pageable);
}
