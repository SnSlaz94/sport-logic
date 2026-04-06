package com.sportlogic.sport_logic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportlogic.sport_logic.model.Jugador;
import com.sportlogic.sport_logic.model.Persona;

public interface JugadorRepository extends JpaRepository<Jugador,Integer>{
    Jugador findByPersona(Persona persona);

}
