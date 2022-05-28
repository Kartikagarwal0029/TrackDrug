package com.example.demo.service;

import com.example.demo.dto.InventoryDto;
import com.example.demo.entity.Inventory;
import com.example.demo.repository.InventoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepo inventoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    public List<Inventory> getAllInventory(){
        return inventoryRepo.findAll();
    }

}
