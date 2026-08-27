package com.example.demo.movie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @ManyToOne
    private Director director;
    @ManyToMany
    private List<Actor> actors;
    @ManyToOne
    private Genre genre;

}
