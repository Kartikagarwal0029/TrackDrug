package com.example.demo.repository;

import com.example.demo.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface InventoryRepo extends JpaRepository<Inventory,Integer> {

}
