package com.example.reto.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class PalabraDTO {
    private long id;

    private String palabra;
    private String ini3;
    private String definicion;
    private int longitud;
    private String similares; //Una lista separada por comas con todas las palabras que empiezan por las mismas 3 letras
}
