package com.example.learn_spring_boot.controller;

import com.example.learn_spring_boot.entity.Category;
import com.example.learn_spring_boot.entity.Product;
import com.example.learn_spring_boot.service.CategoryService;
import com.example.learn_spring_boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {

    @Autowired
    public ProductService productService;
    @Autowired
    public CategoryService categoryService;
    @RequestMapping(method = RequestMethod.GET)
    public Page<Product> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int limit){
        return productService.findAll(page,limit);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable String id){
        Optional<Product> optionalProduct = productService.findById(id);
        return optionalProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> save(@RequestBody Product product){
        return  ResponseEntity.ok(productService.save(product));
    }
}
