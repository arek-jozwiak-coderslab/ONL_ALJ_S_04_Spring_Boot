package com.example.demo.cartoon;

import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartoon")
public class CartoonController {
    private final CartoonRepository cartoonRepository;

    public CartoonController(CartoonRepository cartoonRepository) {
        this.cartoonRepository = cartoonRepository;
    }

    @GetMapping("/{id}")
    public Cartoon find(@PathVariable Long id){
        return cartoonRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(String.format("cartoon %d not found", id)));
    }

    @GetMapping("/upgrade/{id}")
    public Cartoon upgrade(@PathVariable Long id){
        return cartoonRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(String.format("cartoon %d not found", id), ErrorCode.CODE3.toString()));
    }
}
