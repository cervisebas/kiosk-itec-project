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

import com.kiosk.Models.Sale;
import com.kiosk.Models.SaleList;
import com.kiosk.Repositories.SaleRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/sale")
public class SaleController {
  
  @Autowired
  private SaleRepository repository;

  @GetMapping
  public List<Sale> getAll() {
    return repository.findAll();
  }
  
  @PostMapping
  public ResponseEntity<Sale> create(@RequestBody Sale body) {
    Sale save = repository.save(body);

    for (SaleList item : save.getList()) {
      item.setSale(save.clone());
    }

    repository.save(save);
    
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
  public ResponseEntity<Sale> delete(@PathVariable Long id, @RequestBody Sale body) {
    if(!repository.existsById(id)) {
      return ResponseEntity
        .notFound()
        .build();
    }

    body.setId(id);
    Sale saved = repository.save(body);
    return ResponseEntity.ok(saved);
  }
}
