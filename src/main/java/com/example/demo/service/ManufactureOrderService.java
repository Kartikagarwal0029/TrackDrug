package com.example.demo.service;

import com.example.demo.entity.ManufactureOrders;
import com.example.demo.repository.ManufactureOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import java.util.List;
import java.util.Set;

@Service
public class ManufactureOrderService {

    @Autowired
    protected ManufactureOrderRepo manufactureOrderRepo;

    public ManufactureOrders saveManufactureOrder(ManufactureOrders manufactureOrders){
        return manufactureOrderRepo.saveAndFlush(manufactureOrders);
    }

    public ManufactureOrders updatemanufactureorder(ManufactureOrders manufactureOrders){
        ManufactureOrders manufactureOrders1=manufactureOrderRepo.getById(manufactureOrders.getId());
        manufactureOrders1.setManufacturename(manufactureOrders.getManufacturename());
        manufactureOrders1.setRetailOrder(manufactureOrders.getRetailOrder());
        manufactureOrders1.setAccept(manufactureOrders.isAccept());
        manufactureOrders1.setShipment(manufactureOrders.isShipment());
      return manufactureOrderRepo.saveAndFlush(manufactureOrders1);
    }

    public List<ManufactureOrders> getAllorders(String email){
        return manufactureOrderRepo.getManufactureOrdersByManufacturename(email);
    }

    public List<ManufactureOrders> getAllbyaccept(String email){
        return manufactureOrderRepo.getAllByAcceptAndManufacturename(true,email);
    }

    public ManufactureOrders getbyid(int id){
        return manufactureOrderRepo.getById(id);
    }
}
