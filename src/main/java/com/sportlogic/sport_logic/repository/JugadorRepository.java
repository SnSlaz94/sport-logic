package com.sportlogic.sport_logic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportlogic.sport_logic.model.Jugador;
import com.sportlogic.sport_logic.model.Persona;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador,Integer>{
    Jugador findByPersona(Persona persona);

}
