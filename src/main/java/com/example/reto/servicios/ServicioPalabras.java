package com.example.reto.servicios;

import com.example.reto.dto.PalabraDTO;
import com.example.reto.modelo.Palabra;
import com.example.reto.repositorios.RepositorioPalabras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioPalabras {
    @Autowired
    RepositorioPalabras repositorioPalabras;

    public String encuentraSimilares(Palabra palabra) {
        String similares = "";
        for(Palabra p: repositorioPalabras.findByLemaStartsWith(palabra.getLema().substring(0,3))){
            similares += p.getLema() + ", ";
        }
        return similares;
    }
}
