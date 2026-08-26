package com.example.demo.drink;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository  extends JpaRepository<Drink, Long> {
}
