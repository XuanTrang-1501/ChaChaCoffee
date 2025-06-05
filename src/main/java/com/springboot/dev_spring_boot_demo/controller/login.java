package com.springboot.dev_spring_boot_demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.dev_spring_boot_demo.entity.Coffee;
import com.springboot.dev_spring_boot_demo.service.CoffeeService;

@Controller
public class login {
    private CoffeeService coffeeService;

    public login(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping("/home")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                       @RequestParam("password") String password,
                       RedirectAttributes redirectAttributes) {
        // Here you should add your authentication logic
        // For example, check against a user service
        if (isValidUser(username, password)) {
            return "redirect:/home";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid username or password");
            return "redirect:/login";
        }
    }

    private boolean isValidUser(String username, String password) {
        // Implement your user validation logic here
        // This is just a placeholder - you should replace with actual authentication
        return username != null && password != null && !username.isEmpty() && !password.isEmpty();
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        List<Coffee> coffeeList = coffeeService.findAll();
        model.addAttribute("coffeeList", coffeeList);
        return "default/shop";
    }

    @GetMapping("/about")
    public String about() {
        return "default/about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "default/contact";
    }

    @GetMapping("/services")
    public String services() {
        return "default/services";
    }

    @GetMapping("/blog")
    public String blog() {
        return "default/blog";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/menu")
    public String showMenu() {
        return "default/menu";
    }

    @GetMapping("/detailCoffee")
    public String detailCoffee(@RequestParam("id") int id, Model model) {
        Coffee coffee = coffeeService.findById(id);
        model.addAttribute("coffee", coffee);
        return "detailCoffee";
    }

    @GetMapping("/cart")
    public String cart() {
        return "default/cart";
    }
}
