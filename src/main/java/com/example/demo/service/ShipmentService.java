package com.example.demo.service;

import com.example.demo.entity.ShipmentOrder;
import com.example.demo.repository.ShipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentService {

    @Autowired
    private ShipmentRepo shipmentRepo;


    public ShipmentOrder saveshipmentorder(ShipmentOrder shipmentOrder){
        return shipmentRepo.saveAndFlush(shipmentOrder);
    }

    public List<ShipmentOrder> getshipmentorder(){
        return shipmentRepo.findAll();
    }

    public ShipmentOrder updateShipment(ShipmentOrder shipmentOrder){
        ShipmentOrder shipmentOrder1=shipmentRepo.getById(shipmentOrder.getId());
        shipmentOrder1.setAccept(shipmentOrder.isAccept());
        shipmentOrder1.setManufacturename(shipmentOrder.getManufacturename());
        shipmentOrder1.setManufactureOrders(shipmentOrder.getManufactureOrders());
        shipmentRepo.saveAndFlush(shipmentOrder1);
        return shipmentOrder1;
    }



}
