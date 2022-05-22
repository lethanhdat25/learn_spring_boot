package com.example.learn_spring_boot.controller;

import com.example.learn_spring_boot.entity.District;
import com.example.learn_spring_boot.entity.Street;
import com.example.learn_spring_boot.service.DistrictService;
import com.example.learn_spring_boot.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/streets")
public class StreetController {

    @Autowired
    private StreetService streetService;
    @Autowired
    private DistrictService districtService;

     @RequestMapping(method = RequestMethod.GET)
    public Page<Street> findAll(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int limit){
        return streetService.findAll(page, limit);
    }

    @RequestMapping(method = RequestMethod.GET,path = "/{id}")
    public Optional<Street> findId(@PathVariable String id){
         return streetService.findById(id);
    }

    @RequestMapping(method = RequestMethod.PUT,path = "/{id}")
    public ResponseEntity<Street> update(@PathVariable String id,@RequestBody Street street){
         Optional<Street> streetOptional = streetService.findById(id);

         if (!streetOptional.isPresent()){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
         }

         Optional<District> optionalDistrict = districtService.findById(street.getDistrict_id());
         if (!optionalDistrict.isPresent()){
             return ResponseEntity.status(HttpStatus.valueOf("District not found!")).body(null);
         }

         Street streetInDb = streetOptional.get();
         streetInDb.setName(street.getName());
         streetInDb.setDistrict_id((street.getDistrict_id()));
         streetInDb.setDistrict(optionalDistrict.get());
         streetInDb.setUpdatedAt(LocalDateTime.now());
         return ResponseEntity.ok(streetService.save(streetInDb));
    }
}
