package com.kiosk.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiosk.Models.PaymentMethod;
import com.kiosk.Repositories.PaymentMethodRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/payment_method")
public class PaymentMethodController {
  
  @Autowired
  private PaymentMethodRepository repository;

  @GetMapping
  public List<PaymentMethod> getAll() {
    return repository.findAll();
  }
}
