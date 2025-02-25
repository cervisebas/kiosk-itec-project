package com.kiosk.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiosk.Models.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
  
}
