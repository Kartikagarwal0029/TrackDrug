package com.example.demo.repository;

import com.example.demo.entity.ManufactureOrders;
import com.example.demo.entity.ShipmentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepo extends JpaRepository<ShipmentOrder,Integer> {

}
