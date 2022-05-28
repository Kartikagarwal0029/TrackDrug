package com.example.demo.controller;

import com.example.demo.entity.RetailerStock;
import com.example.demo.service.RetailStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RetailerStockController {
    @Autowired
    private RetailStockService retailStockService;

    @GetMapping("/getstock")
    public ModelAndView getstock(Model model){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("stock",retailStockService.getstock(authentication.getName()));
        return new ModelAndView("retailerstock");
    }



}
