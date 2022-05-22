package com.example.learn_spring_boot.repository;

import com.example.learn_spring_boot.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {
    Page<Category> findAll(Pageable pageable);
}
