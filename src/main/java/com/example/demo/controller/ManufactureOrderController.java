package com.example.demo.controller;

import com.example.demo.dto.ManufactureOrderDto;
import com.example.demo.entity.Inventory;
import com.example.demo.entity.ManufactureOrders;
import com.example.demo.entity.RetailOrder;
//import com.example.demo.entity.ShipmentOrder;
import com.example.demo.entity.ShipmentOrder;
import com.example.demo.service.InventoryService;
import com.example.demo.service.ManufactureOrderService;
import com.example.demo.service.RetailOrderService;
import com.example.demo.service.ShipmentService;
import com.sun.org.apache.xpath.internal.operations.Mod;
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

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class ManufactureOrderController {
    @Autowired
    private ManufactureOrderService manufactureOrderService;

    @Autowired
    private ShipmentService shipmentService;

    @GetMapping("/getmanufactureorder")
    public ModelAndView getAllOrders(Model model){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        List<ManufactureOrders> manufactureOrders=manufactureOrderService.getAllorders(authentication.getName());
        model.addAttribute("orders",manufactureOrders);
        ManufactureOrders manufactureOrders1=new ManufactureOrders();
        model.addAttribute("manuorder",manufactureOrders1);
        ShipmentOrder shipmentOrder=new ShipmentOrder();
        model.addAttribute("shipment",shipmentOrder);
        return new ModelAndView("manufactureorders");
    }

    @GetMapping("/getallshipment")
    public ModelAndView getAllshipment(Model model){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        List<ManufactureOrders> manufactureOrders=manufactureOrderService.getAllbyaccept(authentication.getName());
        model.addAttribute("msorder",manufactureOrders);
        ShipmentOrder shipmentOrder=new ShipmentOrder();
        shipmentOrder.setManufacturename(authentication.getName());
        model.addAttribute("shipment",shipmentOrder);
        return new ModelAndView("manufactureshipment");
    }

    @PostMapping("/postmorder")
    public ModelAndView savemanufactureorder(@ModelAttribute ManufactureOrders manufactureOrders){
        manufactureOrders.setShipment(false);
//        if(manufactureOrders.isShipment()){
//            ShipmentOrder shipmentOrder=new ShipmentOrder();
//            shipmentOrder.setAccept(true);
//            shipmentOrder.setManufactureOrders(manufactureOrders);
//            shipmentService.saveshipmentorder(shipmentOrder);
//        }
        manufactureOrderService.updatemanufactureorder(manufactureOrders);
        return new ModelAndView("redirect:/getmanufactureorder");
    }

    @PostMapping("/createshipment")
    public ModelAndView createshipment(@ModelAttribute ShipmentOrder shipmentOrder){
        int id=shipmentOrder.getManufactureOrders().getId();
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        ManufactureOrders manufactureOrders1=manufactureOrderService.getbyid(id);
        manufactureOrders1.setShipment(true);
        shipmentOrder.setManufacturename(authentication.getName());
        manufactureOrderService.updatemanufactureorder(manufactureOrders1);
        shipmentOrder.setAccept(false);
        shipmentService.saveshipmentorder(shipmentOrder);
        return new ModelAndView("redirect:/getallshipment");
    }

}
