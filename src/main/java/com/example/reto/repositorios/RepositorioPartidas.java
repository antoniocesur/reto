package com.example.reto.repositorios;

import com.example.reto.modelo.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPartidas extends JpaRepository<Partida, Long> {

}
