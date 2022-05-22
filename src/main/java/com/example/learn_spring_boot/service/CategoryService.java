package com.example.learn_spring_boot.service;

import com.example.learn_spring_boot.entity.Category;
import com.example.learn_spring_boot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;

    public Page<Category> findAll(int page, int limit){
        return categoryRepository.findAll(PageRequest.of(page,limit));
    }

    public Optional<Category> findById(String id){
        return  categoryRepository.findById(id);
    }

    public Category save(Category category){return categoryRepository.save(category);}

    public void delete(String id){
        categoryRepository.deleteById(id);
    }

}
