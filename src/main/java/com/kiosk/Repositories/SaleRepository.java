package com.kiosk.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiosk.Models.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
  
}
