package com.example.learn_spring_boot.service;

import com.example.learn_spring_boot.entity.Street;
import com.example.learn_spring_boot.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StreetService {
    @Autowired
    public StreetRepository streetRepository;

    public Page<Street> findAll(int page, int limit) {
        return streetRepository.findAll(PageRequest.of(page, limit));
    }

    public Street save(Street street) {
        return streetRepository.save(street);
    }

    public void deleteById(String id) {
        streetRepository.deleteById(id);
    }

    public Optional<Street> findById(String id) {
        return streetRepository.findById(id);
    }

}
