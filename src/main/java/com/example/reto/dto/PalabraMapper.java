package com.example.reto.dto;

import com.example.reto.modelo.Palabra;
import com.example.reto.repositorios.RepositorioPalabras;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class PalabraMapper {
    @Autowired
    RepositorioPalabras repositorioPalabras;
    public PalabraDTO mapPalabra(Palabra palabra){
        /*String similares = "";
        for(Palabra p: repositorioPalabras.findByPalabraStartsWith(palabra.getPalabra().substring(0,3))){
            similares += p.getPalabra() + ", ";
        }*/

        return PalabraDTO.builder()
                .palabra(palabra.getLema())
                .definicion(palabra.getDefinicion())
                .longitud(palabra.getLongitud())
                .ini3(palabra.getLema().substring(0,3))
                .similares("")
                .build();
    }
}

