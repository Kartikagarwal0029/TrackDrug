package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {


    @GetMapping("/index")
    public String gethome(){
        return "index";
    }

    @GetMapping("/graph")
    public String geth(){
        return "xyz";
    }
}
