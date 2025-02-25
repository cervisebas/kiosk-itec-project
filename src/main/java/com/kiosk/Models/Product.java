package com.kiosk.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_product_category")
  private ProductCategory product_category;

  private String name;
  private Integer code;
  private Integer quantity;
  private Float price;
}
