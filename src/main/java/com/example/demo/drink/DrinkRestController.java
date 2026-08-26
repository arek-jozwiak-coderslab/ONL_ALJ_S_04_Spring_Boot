package com.example.demo.drink;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/drinks")
public class DrinkRestController {

    private final DrinkRepository repository;

    public DrinkRestController(DrinkRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Drink> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drink> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Drink> create(@Valid @RequestBody Drink drink) {
        Drink saved = repository.save(drink);
        return ResponseEntity.created(URI.create("/api/drinks/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drink> update(@PathVariable Long id, @Valid @RequestBody Drink drink) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(drink.getName());
                    existing.setDescription(drink.getDescription());
                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
