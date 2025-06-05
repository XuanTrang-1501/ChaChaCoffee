package com.springboot.dev_spring_boot_demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.dev_spring_boot_demo.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
}