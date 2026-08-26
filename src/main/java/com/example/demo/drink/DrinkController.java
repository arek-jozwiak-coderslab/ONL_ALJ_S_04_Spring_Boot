package com.example.demo.drink;


import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @GetMapping("/new")
    public String add(Model model){
        model.addAttribute("drink", new Drink());
        return "/drink/add";
    }
    @PostMapping("/new")
    public String create(@Valid Drink drink, BindingResult result, RedirectAttributes ra) {
        if (result.hasErrors()) {
            return "/drink/add";
        }
        repository.save(drink);
        ra.addFlashAttribute("message", "Drink utworzony.");
        return "redirect:/drink/list";
    }
    @GetMapping("/{id}/delete")
    public String add(@PathVariable Long id){
        repository.deleteById(id);
        return "redirect:/drink/list";
    }

}
