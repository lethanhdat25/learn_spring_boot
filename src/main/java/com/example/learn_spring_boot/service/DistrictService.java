package com.example.learn_spring_boot.service;

import com.example.learn_spring_boot.entity.District;
import com.example.learn_spring_boot.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DistrictService {

    @Autowired
    public DistrictRepository districtRepository;

    public Page<District> findAll(int page, int limit){
        return districtRepository.findAll(PageRequest.of(page,limit));
    }

    public Optional<District> findById(String id){
        return districtRepository.findById(id);
    }

}
