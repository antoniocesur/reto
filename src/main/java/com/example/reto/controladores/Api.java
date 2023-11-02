package com.example.reto.controladores;

import com.example.reto.dto.PalabraDTO;
import com.example.reto.dto.PalabraMapper;
import com.example.reto.modelo.Palabra;
import com.example.reto.modelo.PalabrasPartida;
import com.example.reto.modelo.Partida;
import com.example.reto.repositorios.RepositorioPalabras;
import com.example.reto.repositorios.RepositorioPalabrasPartida;
import com.example.reto.repositorios.RepositorioPartidas;
import com.example.reto.servicios.ServicioPalabras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Api {
    @Autowired
    RepositorioPalabras repositorioPalabras;
    @Autowired
    RepositorioPartidas repositorioPartidas;
    @Autowired
    RepositorioPalabrasPartida repositorioPalabrasPartida;

    @CrossOrigin(origins = "http://localhost")
    @GetMapping(value="/lista7")
    public @ResponseBody List<PalabraDTO> lista6Palabras() {
        //Recupero una lista de 6 palabras aleatorias
        ArrayList<Palabra> lista=repositorioPalabras.find7();

        //Convierto la lista en un DTO
        PalabraMapper palabraMapper=new PalabraMapper();
        ArrayList<PalabraDTO> listaDTO=new ArrayList<>();
        for(Palabra p:lista){
            listaDTO.add(palabraMapper.mapPalabra(p));
        }

        Partida partida=new Partida();
        partida.setFecha(LocalDate.now());
        partida.setFechaHora(LocalDateTime.now());
        repositorioPartidas.save(partida);

        for(Palabra p:lista){
            PalabrasPartida pp=new PalabrasPartida();
            pp.setPalabra(p);
            pp.setPartida(partida);
            repositorioPalabrasPartida.save(pp);
        }

        return listaDTO;
    }
}
