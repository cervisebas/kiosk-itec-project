package com.kiosk.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiosk.Models.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
  
}
