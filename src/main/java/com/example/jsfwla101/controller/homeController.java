package com.example.jsfwla101.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/" )
public class homeController {
    @GetMapping
    public String home() {
        System.out.println("Test");
        System.out.println("Hello");
        return "redirect:/itCertManagement/show";
    }
}
