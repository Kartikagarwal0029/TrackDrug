package com.example.demo.service;

import com.example.demo.dto.InventoryDto;
import com.example.demo.dto.RetailOrderDto;
import com.example.demo.entity.Inventory;
import com.example.demo.entity.RetailOrder;
import com.example.demo.entity.User;
import com.example.demo.repository.InventoryRepo;
import com.example.demo.repository.RetailOrderRepo;
import com.example.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RetailOrderService {
    @Autowired
    private RetailOrderRepo retailOrderRepo;
    @Autowired
    private InventoryRepo inventoryRepo;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public RetailOrder saveRetailOrder(RetailOrder retailOrder){
        retailOrder.setAcceptshipment(false);
        retailOrderRepo.saveAndFlush(retailOrder);
        return retailOrder;
    }

    public RetailOrder updateRetailorder(RetailOrder retailOrder){
    RetailOrder retailOrder1=retailOrderRepo.getById(retailOrder.getId());
    retailOrder1.setAccepted(retailOrder.isAccepted());
    retailOrder1.setAcceptshipment(retailOrder.isAcceptshipment());
    retailOrderRepo.saveAndFlush(retailOrder1);
        return retailOrder1;
    }

    public RetailOrder getbyid(int id){
        return retailOrderRepo.getById(id);
    }

    public List<RetailOrder> getRetailOrder(String name){
        return retailOrderRepo.getByName(name);
    }



}
