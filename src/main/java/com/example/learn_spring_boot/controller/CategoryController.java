package com.example.learn_spring_boot.controller;

import com.example.learn_spring_boot.entity.Category;
import com.example.learn_spring_boot.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/categories")
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Category> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int limit){
        return categoryService.findAll(page,limit);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable String id){
        Optional<Category> optionalCategory = categoryService.findById(id);
        return optionalCategory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Category> save(@RequestBody Category category){
        return  ResponseEntity.ok(categoryService.save(category));
    }
}
