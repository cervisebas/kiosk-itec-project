package com.kiosk.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiosk.Models.ProductCategory;
import com.kiosk.Repositories.ProductCategoryRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/product_category")
public class ProductCategoryController {
  
  @Autowired
  private ProductCategoryRepository repository;

  @GetMapping
  public List<ProductCategory> getAll() {
    return repository.findAll();
  }
  
  @PostMapping
  public ResponseEntity<ProductCategory> create(@RequestBody ProductCategory body) {
    ProductCategory save = repository.save(body);
    
    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(save);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id){
    if(!repository.existsById(id)) {
      return ResponseEntity
        .notFound()
        .build();
    }

    repository.deleteById(id);
    return ResponseEntity
      .noContent()
      .build();
  }
}
