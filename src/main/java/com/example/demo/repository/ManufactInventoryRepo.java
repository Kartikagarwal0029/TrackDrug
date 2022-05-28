package com.example.demo.repository;

import com.example.demo.entity.Inventory;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ManufactInventoryRepo extends JpaRepository<Inventory,Integer> {

    Set<Inventory> getByUser(User user);
}
