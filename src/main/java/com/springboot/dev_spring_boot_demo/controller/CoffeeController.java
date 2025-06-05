package com.springboot.dev_spring_boot_demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.dev_spring_boot_demo.entity.Coffee;
import com.springboot.dev_spring_boot_demo.service.CoffeeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/coffee")
public class CoffeeController {
    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping("/list-coffee")
    public String listCoffee(Model model) {
        List<Coffee> coffeeList = coffeeService.findAll();
        model.addAttribute("coffee", coffeeList);
        return "admin/coffee/list-coffee";
    }

    @GetMapping("/coffee-form-insert")
    public String showInsertForm(Model model) {
        model.addAttribute("coffee", new Coffee()); 
        return "admin/coffee/coffee-form-insert"; 
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("coffee") Coffee coffee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Nếu có lỗi, quay lại form nhập với danh sách lỗi
            model.addAttribute("error", "Dữ liệu nhập không hợp lệ. Vui lòng kiểm tra lại.");
            return "admin/coffee/coffee-form-insert"; // Trả về trang nhập dữ liệu
        }

        coffeeService.save(coffee);
        return "redirect:/admin/coffee/list-coffee";
    }


    @GetMapping("/coffee-form-update")
    public String formUpdate(@RequestParam("id") int id, Model model) {
        Coffee coffee = coffeeService.findById(id);
        model.addAttribute("coffee", coffee);
        return "admin/coffee/coffee-form-update";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        coffeeService.deleteById(id);
        return "redirect:/admin/coffee/list-coffee";
    }

    @GetMapping("/coffee-detail")
    public String coffeeDetail(@RequestParam("id") int id, Model model) {
        // Get the coffee by id using the existing findById method
        Coffee coffee = coffeeService.findById(id);
        
        if (coffee == null) {
            return "redirect:/shop"; // Redirect to shop if coffee not found
        }
        
        // For related coffees, we can use the findAll method and filter out the current coffee
        List<Coffee> allCoffees = coffeeService.findAll();
        List<Coffee> relatedCoffees = allCoffees.stream()
                .filter(c -> c.getId() != id)
                .limit(4)  // Limit to 4 related coffees
                .toList();
        
        // Add attributes to the model
        model.addAttribute("coffee", coffee);
        model.addAttribute("relatedCoffees", relatedCoffees);
        
        return "default/coffee-detail";
    }
}
