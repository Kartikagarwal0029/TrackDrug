package com.example.demo.controller;

import com.example.demo.entity.Inventory;
import com.example.demo.entity.ManufactureOrders;
import com.example.demo.entity.RetailOrder;
import com.example.demo.service.InventoryService;
import com.example.demo.service.ManufactureOrderService;
import com.example.demo.service.RetailOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private RetailOrderService retailOrderService;

    @Autowired
    private ManufactureOrderService manufactureOrderService;

    @GetMapping("/rinventory")
    public ModelAndView getAllInventory(Model model){
        List<Inventory> inventories=inventoryService.getAllInventory();
        RetailOrder retailOrder=new RetailOrder();
        model.addAttribute("retailOrder",retailOrder);
      model.addAttribute("totalrinventory",inventories);
      return new ModelAndView("retailinventory");
    }

    @PostMapping("/postquantity")
    public ModelAndView setQuantity(@ModelAttribute RetailOrder retailOrder){
        int quantity=retailOrder.getQuantity();
        System.out.println(quantity);
        Inventory inventory=retailOrder.getInventory();
        System.out.println(inventory);
        inventory.setBoxes(inventory.getBoxes()-quantity);
        retailOrder.setInventory(inventory);
        retailOrder.setName(SecurityContextHolder.getContext().getAuthentication().getName());
        ManufactureOrders manufactureOrders=new ManufactureOrders();
        manufactureOrders.setManufacturename(inventory.getUser().getEmail());
        manufactureOrders.setShipment(false);
        manufactureOrders.setAccept(false);
        retailOrderService.saveRetailOrder(retailOrder);
        manufactureOrders.setRetailOrder(retailOrder);
        manufactureOrderService.saveManufactureOrder(manufactureOrders);
        return new ModelAndView("redirect:/rinventory");
    }


//    @PostMapping("/postquantity")
//    public ModelAndView setQuantity(@ModelAttribute Inventory inventory){
//        int quantity=retailOrder.getQuantity();
//        System.out.println(quantity);
//        Inventory inventory=retailOrder.getInventory();
//        System.out.println(inventory);
//        inventory.setBoxes(inventory.getBoxes()-quantity);
//        retailOrder.setInventory(inventory);
//        retailOrder.setName(SecurityContextHolder.getContext().getAuthentication().getName());
//        ManufactureOrders manufactureOrders=new ManufactureOrders();
//        manufactureOrders.setManufacturename(inventory.getUser().getEmail());
//        manufactureOrders.setShipment(false);
//        manufactureOrders.setAccept(false);
//        retailOrderService.saveRetailOrder(retailOrder);
//        manufactureOrders.setRetailOrder(retailOrder);
//        manufactureOrderService.saveManufactureOrder(manufactureOrders);
//        return new ModelAndView("redirect:/rinventory");
//    }

}
