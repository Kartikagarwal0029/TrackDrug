package com.example.demo.repository;

import com.example.demo.entity.ManufactureOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManufactureOrderRepo extends JpaRepository<ManufactureOrders,Integer> {

    List<ManufactureOrders> getManufactureOrdersByManufacturename(String email);
    List<ManufactureOrders> getAllByAcceptAndManufacturename(boolean accept,String email);
}
