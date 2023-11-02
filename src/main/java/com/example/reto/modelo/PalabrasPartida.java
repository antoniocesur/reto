package com.example.reto.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PalabrasPartida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Partida partida;

    @ManyToOne
    private Palabra palabra;

}
