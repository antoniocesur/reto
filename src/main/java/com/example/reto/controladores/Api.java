package com.example.reto.controladores;

import com.example.reto.dto.PalabraDTO;
import com.example.reto.dto.PalabraMapper;
import com.example.reto.modelo.Palabra;
import com.example.reto.repositorios.RepositorioPalabras;
import com.example.reto.servicios.ServicioPalabras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Api {
    @Autowired
    RepositorioPalabras repositorioPalabras;

    @GetMapping(value="/lista6")
    public @ResponseBody List<PalabraDTO> lista6Palabras() {
        //Recupero una lista de 6 palabras aleatorias
        ArrayList<Palabra> lista=repositorioPalabras.find6();

        //Convierto la lista en un DTO
        PalabraMapper palabraMapper=new PalabraMapper();
        ArrayList<PalabraDTO> listaDTO=new ArrayList<>();
        for(Palabra p:lista){
            listaDTO.add(palabraMapper.mapPalabra(p));
        }

        return listaDTO;
    }
}
