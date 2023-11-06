package com.example.reto.repositorios;

import com.example.reto.modelo.Palabra;
import com.example.reto.modelo.PalabrasPartida;
import com.example.reto.modelo.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface RepositorioPalabrasPartida extends JpaRepository<PalabrasPartida, Long> {
    public ArrayList<PalabrasPartida> findByPartida(Partida partida);
}
