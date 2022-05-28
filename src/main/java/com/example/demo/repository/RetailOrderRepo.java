package com.example.demo.repository;

import com.example.demo.dto.InventoryDto;
import com.example.demo.entity.Inventory;
import com.example.demo.entity.RetailOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RetailOrderRepo extends JpaRepository<RetailOrder,Integer> {

    List<RetailOrder> getByName(String name);

}
