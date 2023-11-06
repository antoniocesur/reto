package com.example.reto.repositorios;

import com.example.reto.modelo.Palabra;
import com.example.reto.modelo.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RepositorioPartidas extends JpaRepository<Partida, Long> {
    @Query(value = "SELECT * FROM partida ORDER BY RAND() LIMIT 1", nativeQuery = true)
    public Partida find1();
}
