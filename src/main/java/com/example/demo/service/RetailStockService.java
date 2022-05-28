package com.example.demo.service;

import com.example.demo.entity.RetailerStock;
import com.example.demo.repository.RetailStockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetailStockService {

    @Autowired
    private RetailStockRepo retailStockRepo;

    public RetailerStock savestock(RetailerStock retailerStock){
        return retailStockRepo.save(retailerStock);
    }

    public List<RetailerStock> getstock(String name){
       return retailStockRepo.findAllByRetailername(name);
    }


}
