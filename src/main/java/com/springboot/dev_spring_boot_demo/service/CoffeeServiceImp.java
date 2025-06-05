package com.springboot.dev_spring_boot_demo.service;

import com.springboot.dev_spring_boot_demo.dao.CoffeeDAO;
import com.springboot.dev_spring_boot_demo.entity.Coffee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeServiceImp implements CoffeeService {
    private CoffeeDAO coffeeDAO;

    @Autowired
    public CoffeeServiceImp(CoffeeDAO coffeeDAO) {
        this.coffeeDAO = coffeeDAO;
    }

    @Override
    public List<Coffee> findAll() {
        return coffeeDAO.findAll();
    }

    @Override
    public Coffee findById(int id) {
        return coffeeDAO.findById(id);
    }

    @Override
    public Coffee save(Coffee coffee) {
        return coffeeDAO.save(coffee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        coffeeDAO.deleteById(id);
    }
}
