package com.springboot.dev_spring_boot_demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.dev_spring_boot_demo.entity.Coffee;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
}
