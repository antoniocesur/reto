package com.example.reto.controladores;

import com.example.reto.dto.PalabraDTO;
import com.example.reto.dto.PalabraMapper;
import com.example.reto.modelo.Palabra;
import com.example.reto.repositorios.RepositorioPalabras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class Principal {
    @Autowired
    RepositorioPalabras repositorioPalabras;

    @GetMapping("/")
    public String principal(Model model){

        //Recupero una lista de 6 palabras aleatorias
        ArrayList<Palabra> lista=repositorioPalabras.find6();

        //Convierto la lista en un DTO
        PalabraMapper palabraMapper=new PalabraMapper();
        ArrayList<PalabraDTO> listaDTO=new ArrayList<>();
        for(Palabra p:lista){
            listaDTO.add(palabraMapper.mapPalabra(p));
        }
        model.addAttribute("lista", listaDTO);

        //Elijo un definición aleatoria de palabra, ya no lo uso, mejor una lista desordenada
        /*int n= ThreadLocalRandom.current().nextInt(0, 7);
        model.addAttribute("definicion", listaDTO.get(n).getDefinicion());*/

        //Envío otra lista desordenada
        ArrayList<PalabraDTO> desordenada=new ArrayList<>(listaDTO);
        Collections.shuffle(desordenada);
        model.addAttribute("desordenada", desordenada);

        return "reto";
    }

    @GetMapping(value={"/retojs", "/reto2"})
    public String retojs(){
        return "retojs";
    }

}
