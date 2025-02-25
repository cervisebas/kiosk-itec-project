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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiosk.Models.Product;
import com.kiosk.Repositories.ProductRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/product")
public class ProductController {
  
  @Autowired
  private ProductRepository repository;

  @GetMapping
  public List<Product> getAll() {
    return repository.findAll();
  }
  
  @PostMapping
  public ResponseEntity<Product> create(@RequestBody Product body) {
    Product save = repository.save(body);
    
    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(save);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
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

  @PutMapping("/{id}")
  public ResponseEntity<Product> delete(@PathVariable Long id, @RequestBody Product body) {
    if(!repository.existsById(id)) {
      return ResponseEntity
        .notFound()
        .build();
    }

    body.setId(id);
    Product saved = repository.save(body);
    return ResponseEntity.ok(saved);
  }
}
