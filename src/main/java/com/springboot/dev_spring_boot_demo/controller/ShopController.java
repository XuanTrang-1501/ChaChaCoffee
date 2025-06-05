package com.springboot.dev_spring_boot_demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.dev_spring_boot_demo.entity.Coffee;
import com.springboot.dev_spring_boot_demo.service.CoffeeService;

@Controller
public class ShopController {
    private final CoffeeService coffeeService;

    public ShopController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping("/coffee-shop") 
    public String shop(Model model) {
        List<Coffee> coffeeList = coffeeService.findAll();
        model.addAttribute("coffeeList", coffeeList);
        return "default/shop";
    }

    @GetMapping("/coffee-detail")
    public String coffeeDetail(@RequestParam("id") int id, Model model) {
        Coffee coffee = coffeeService.findById(id);
        
        if (coffee == null) {
            return "redirect:/shop";
        }
        
        // Get related coffees (all coffees except the current one, limited to 4)
        List<Coffee> allCoffees = coffeeService.findAll();
        List<Coffee> relatedCoffees = allCoffees.stream()
                .filter(c -> c.getId() != id)
                .limit(4)
                .toList();
        
        model.addAttribute("coffee", coffee);
        model.addAttribute("relatedCoffees", relatedCoffees);
        
        return "default/coffee-detail";
    }
}