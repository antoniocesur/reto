package com.example.reto.dto;

import com.example.reto.modelo.Palabra;

public class PalabraMapper {
    public PalabraDTO mapPalabra(Palabra palabra){
        return PalabraDTO.builder()
                .palabra(palabra.getPalabra())
                .definicion(palabra.getDefinicion())
                .longitud(palabra.getLongitud())
                .ini3(palabra.getPalabra().substring(0,3))
                .build();
    }
}

