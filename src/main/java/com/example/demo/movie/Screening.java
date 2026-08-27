package com.example.demo.movie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Movie movie;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    private CinemaHall cinemaHall;
}
