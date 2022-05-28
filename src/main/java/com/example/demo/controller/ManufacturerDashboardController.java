package com.example.demo.controller;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RestController;

@Controller
public class ManufacturerDashboardController {
    @GetMapping("/gra")
    public String getPieChart(Model model) {
        Map<String, Integer> graphData = new TreeMap<>();
        graphData.put("2016", 147);
        graphData.put("2017", 1256);
        graphData.put("2018", 3856);
        graphData.put("2019", 8000);
        graphData.put("2020", 15000);
        graphData.put("2021", 20000);
        graphData.put("2022", 6000);
        model.addAttribute("chartData", graphData);
        model.addAttribute("matData", graphData);


        return "xyz";
    }


}
