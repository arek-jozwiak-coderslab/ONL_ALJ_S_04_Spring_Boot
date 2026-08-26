package com.example.demo.drink;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drink")
public class DrinkController {

    private final DrinkRepository repository;

    public DrinkController(DrinkRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("drinks", repository.findAll());
        return "/drink/list";
    }
}
