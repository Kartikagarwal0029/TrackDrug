package com.example.demo.controller;

import com.example.demo.dto.InventoryDto;
import com.example.demo.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@Controller
public class ManfInventController {
    @Autowired
    private ManufactureService manufactureService;

    @RequestMapping(value = "/addinvent",method = RequestMethod.POST)
    public ModelAndView addInventory(@ModelAttribute InventoryDto inventoryDto){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
            String email=authentication.getName();
        manufactureService.createInventory(email,inventoryDto);
         return new ModelAndView("redirect:/getallinvent");
    }

    @RequestMapping(value = "/manfinvent",method = RequestMethod.GET)
    public ModelAndView addInventory(Model model){
        InventoryDto inventoryDto=new InventoryDto();
        model.addAttribute("addmanfinvent",inventoryDto);
        return new ModelAndView("manfinventform");
    }

    @RequestMapping(value = "/getallinvent")
    public ModelAndView getAllInventory(Model model){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String email=authentication.getName();
        model.addAttribute("getallmanfinvent",manufactureService.getAllInventory(email));
        return new ModelAndView("manfinvent");
    }

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public ModelAndView homee(){
        return new ModelAndView("facility");
    }
}
