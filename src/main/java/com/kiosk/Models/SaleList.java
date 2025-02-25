package com.kiosk.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "sale_lists")
public class SaleList {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_sale")
  private Sale sale;

  @ManyToOne
  @JoinColumn(name = "id_product")
  private Product product;

  private Integer quantity;
  private Float price;
}
