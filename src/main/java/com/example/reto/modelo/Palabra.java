package com.example.reto.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "diccionario")
public class Palabra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    private String palabra;
    private String definicion;
    private int longitud;

}
