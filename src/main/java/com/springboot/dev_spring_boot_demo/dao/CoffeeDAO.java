package com.springboot.dev_spring_boot_demo.dao;

import com.springboot.dev_spring_boot_demo.entity.Coffee;

import java.util.List;

public interface CoffeeDAO {
    List<Coffee> findAll();
    Coffee findById(int id);
    Coffee save(Coffee coffee);
    void deleteById(int id);
}
