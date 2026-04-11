package com.sportlogic.sport_logic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sportlogic.sport_logic.model.FichaMedica;
import com.sportlogic.sport_logic.model.Jugador;

public interface FichaMedicaRepository extends JpaRepository<FichaMedica, Integer> {
    
    FichaMedica findByJugador(Jugador jugador);

    // Esta es la clave para que el controlador no marque error
    @Query("SELECT f FROM FichaMedica f WHERE f.jugador.id_jugador = :id")
    FichaMedica findByJugadorId(@Param("id") Integer id);
}