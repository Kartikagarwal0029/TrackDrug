package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.RetailOrder;
import com.example.demo.entity.ShipmentOrder;
import com.example.demo.service.MyUserDetailService;
import com.example.demo.service.RetailOrderService;
import com.example.demo.service.ShipmentService;
import com.example.demo.userDetail.MyUserDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.TreeMap;

@Controller
public class ShipmentController {
    @Autowired
    private ShipmentService shipmentService;
    @Autowired
    private RetailOrderService retailOrderService;

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/getshipments")
    public ModelAndView getallorders(Model model){
        model.addAttribute("shipmentorders",shipmentService.getshipmentorder());
        ShipmentOrder shipmentOrder=new ShipmentOrder();
        model.addAttribute("acceptship",shipmentOrder);
        return new ModelAndView("shipmentorders");
    }

    @GetMapping("/shipmentdash")
    public ModelAndView getshipdash(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails myUserDetails=myUserDetailService.getUser(authentication.getName());
        UserDto userDto=modelMapper.map(myUserDetails,UserDto.class);
        model.addAttribute("shipdashdata",userDto);
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
        return new ModelAndView("transportdashboard");
    }

    @PostMapping("/shipment")
    public ModelAndView acceptshipment(@ModelAttribute ShipmentOrder shipmentOrder){
        int id=shipmentOrder.getManufactureOrders().getRetailOrder().getId();
        RetailOrder retailOrder=retailOrderService.getbyid(id);
        retailOrder.setAccepted(true);
        retailOrderService.updateRetailorder(retailOrder);
        shipmentService.updateShipment(shipmentOrder);
        return new ModelAndView("redirect:/getshipments");
    }

}
