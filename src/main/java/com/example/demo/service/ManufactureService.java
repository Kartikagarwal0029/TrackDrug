package com.example.demo.service;

import com.example.demo.dto.InventoryDto;
import com.example.demo.entity.Inventory;
import com.example.demo.entity.User;
import com.example.demo.repository.ManufactInventoryRepo;
import com.example.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ManufactureService {
    @Autowired
    private ManufactInventoryRepo manufactInventoryRepo;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public InventoryDto createInventory(String email,InventoryDto inventoryDto){
        Inventory inventory=modelMapper.map(inventoryDto,Inventory.class);
        Optional<User> user=userRepository.findByEmail(email);
        inventory.setUser(user.get());
        manufactInventoryRepo.save(inventory);
        return inventoryDto;
    }

    public Set<InventoryDto> getAllInventory(String email){
        Optional<User> user=userRepository.findByEmail(email);
        Set<Inventory> inventories=manufactInventoryRepo.getByUser(user.get());
        Set<InventoryDto> inventoryDtos=inventories.stream().map(t->modelMapper.map(t,InventoryDto.class)).collect(Collectors.toSet());
        return inventoryDtos;
    }

}
