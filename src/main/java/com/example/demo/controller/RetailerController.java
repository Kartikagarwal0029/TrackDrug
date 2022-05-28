package com.example.demo.controller;

import com.example.demo.dto.RetailOrderDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Inventory;
import com.example.demo.entity.RetailOrder;
import com.example.demo.entity.RetailerStock;
import com.example.demo.service.*;
import com.example.demo.userDetail.MyUserDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Controller
public class RetailerController {
    @Autowired
    private ShipmentService shipmentService;
    @Autowired
    private RetailOrderService retailOrderService;
    @Autowired
    private RetailStockService retailStockService;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MyUserDetailService myUserDetailService;

    @GetMapping("rorders")
    public ModelAndView getOrders(Model model){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        List<RetailOrder> retailOrders=retailOrderService.getRetailOrder(authentication.getName());
List<RetailOrder> retailOrders1=retailOrders.stream().filter(t->t.isAcceptshipment()==false).collect(Collectors.toList());
        model.addAttribute("Rorder",retailOrders1);
        RetailerStock retailerStock=new RetailerStock();
        model.addAttribute("retailstock",retailerStock);
        return new ModelAndView("retailorders");
    }

    @GetMapping("/retaildash")
    public String retailerDashboard(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails myUserDetails=myUserDetailService.getUser(authentication.getName());
        UserDto userDto=modelMapper.map(myUserDetails,UserDto.class);
        model.addAttribute("retaildashdata",userDto);
        Map<String, Integer> graphData = new TreeMap<>();
        graphData.put("2016", 147);
        graphData.put("2017", 1256);
        graphData.put("2018", 3856);
        graphData.put("2019", 8000);
        graphData.put("2020", 15000);
        graphData.put("2021", 20000);
        graphData.put("2022", 6000);
        model.addAttribute("chartData", graphData);
        model.addAttribute("barData", graphData);

        return "retailerdashboard";
    }

    @PostMapping("/acceptshipment")
    public ModelAndView acceptshipment(@ModelAttribute RetailerStock retailerStock){
        RetailOrder retailOrder=retailOrderService.getbyid(retailerStock.getRetailOrder().getId());
        retailOrder.setAcceptshipment(true);
        retailOrderService.updateRetailorder(retailOrder);
        retailStockService.savestock(retailerStock);
            return new ModelAndView("redirect:/rorders");
    }
}
