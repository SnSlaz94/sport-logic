package com.sportlogic.sport_logic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportlogic.sport_logic.model.FichaMedica;
import com.sportlogic.sport_logic.model.Jugador;

public interface FichaMedicaRepository extends JpaRepository<FichaMedica, Integer> {
    FichaMedica findByJugador(Jugador jugador);
}