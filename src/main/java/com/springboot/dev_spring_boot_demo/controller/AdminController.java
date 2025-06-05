package com.springboot.dev_spring_boot_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {
    @GetMapping("/coffee-list")
    public String coffeeList(){
        return "admin/coffee";
    }

    @GetMapping("/system")
    public String system(){
        return "admin/system/system";
    }

}
