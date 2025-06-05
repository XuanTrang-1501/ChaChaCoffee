package com.springboot.dev_spring_boot_demo.service;

import java.util.List;

import com.springboot.dev_spring_boot_demo.entity.Coffee;

public interface CoffeeService {
    List<Coffee> findAll();
    Coffee findById(int id);
    Coffee save(Coffee coffee);
    void deleteById(int id);

    
}


