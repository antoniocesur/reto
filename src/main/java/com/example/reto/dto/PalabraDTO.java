package com.example.reto.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PalabraDTO {
    private long id;

    private String palabra;
    private String ini3;
    private String definicion;
    private int longitud;
}
