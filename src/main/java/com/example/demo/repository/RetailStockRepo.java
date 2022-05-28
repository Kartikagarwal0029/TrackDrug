package com.example.demo.repository;

import com.example.demo.entity.RetailerStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RetailStockRepo extends JpaRepository<RetailerStock,Integer> {

    List<RetailerStock> findAllByRetailername(String retailername);
}
