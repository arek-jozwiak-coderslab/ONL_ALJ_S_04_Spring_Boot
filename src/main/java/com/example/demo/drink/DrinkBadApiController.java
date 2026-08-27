package com.example.demo.drink;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/level0")
public class DrinkBadApiController {
    private final DrinkRepository repository;

    public DrinkBadApiController(DrinkRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Drink> all(){
        return repository.findAll();
    }
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}
