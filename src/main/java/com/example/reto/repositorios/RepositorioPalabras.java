package com.example.reto.repositorios;

import com.example.reto.modelo.Palabra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface RepositorioPalabras extends JpaRepository<Palabra, Long> {
    public ArrayList<Palabra> findAll();

    //SELECT palabra p, definicion FROM diccionario where longitud>4 ORDER BY RAND() LIMIT 6
    @Query(value = "SELECT * FROM diccionario where longitud>4 ORDER BY RAND() LIMIT 6", nativeQuery = true)
    public ArrayList<Palabra> find6();
}
