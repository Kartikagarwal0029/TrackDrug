package com.example.demo.repository;

import com.example.demo.entity.xyz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface xyzcontroller extends JpaRepository<xyz,Integer> {
}
