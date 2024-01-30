package com.example.demo.dao;

import com.example.demo.model.Chien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChienRepository extends JpaRepository<Chien, Integer> {
}