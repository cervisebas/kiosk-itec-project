package com.kiosk.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiosk.Models.SaleList;

public interface SaleListRepository extends JpaRepository<SaleList, Long> {
  
}
