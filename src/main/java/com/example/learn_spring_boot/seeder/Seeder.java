package com.example.learn_spring_boot.seeder;

import com.example.learn_spring_boot.entity.Category;
import com.example.learn_spring_boot.entity.District;
import com.example.learn_spring_boot.entity.Street;
import com.example.learn_spring_boot.repository.CategoryRepository;
import com.example.learn_spring_boot.repository.DistrictRepository;
import com.example.learn_spring_boot.repository.StreetRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class Seeder  implements CommandLineRunner {


    final DistrictRepository districtRepository;
    final StreetRepository streetRepository;
    final CategoryRepository categoryRepository;
     final Faker faker;

    public Seeder(DistrictRepository districtRepository, StreetRepository streetRepository, CategoryRepository categoryRepository) {
        this.districtRepository = districtRepository;
        this.streetRepository = streetRepository;
        this.categoryRepository = categoryRepository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {
        streetRepository.deleteAll();
        districtRepository.deleteAll();
        seedDistrict();
        seedStreet();
    }

    private void seedStreet(){

        List<District> districts = districtRepository.findAll();
        List<Street> streetList = new ArrayList<Street>();
        for (int i =0 ;i<=100;i++){
            Street street = new Street();
            street.setDistrict_id(districts.get(i).getId());
            street.setDistrict(districts.get(i));
            street.setName(faker.name().title());
            street.setId(UUID.randomUUID().toString());
            streetList.add(street);
        }
        streetRepository.saveAll(streetList);


    }

    private void seedDistrict() {
        List<District> districtList = new ArrayList<>();
        for (int i= 0; i<=100; i++){
            District district = new District();
            district.setId(UUID.randomUUID().toString());
            district.setName(faker.name().title());
            districtList.add(district);
        }
        districtRepository.saveAll(districtList);
    }

    private void seedCategory(){
        List<Category> categories = new ArrayList<>();
//        List<Product>
        for (int i = 0; i<20;i++){

        }
    }
}
