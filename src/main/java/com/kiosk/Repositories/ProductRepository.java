package com.kiosk.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiosk.Models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  
}
