package com.kiosk.Models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "sales")
public class Sale {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_payment_method")
  private PaymentMethod payment_method;

  @OneToMany(
    mappedBy = "sale",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<SaleList> list;

  private Float total;
}
