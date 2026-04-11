package com.sportlogic.sport_logic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sportlogic.sport_logic.model.SesionEntrenamiento;
import java.util.List;

public interface SesionEntrenamientoRepository extends JpaRepository<SesionEntrenamiento,Integer>{
    @Query("SELECT s FROM SesionEntrenamiento s WHERE s.horario.id_horario = " +
       "(SELECT j.horario.id_horario FROM Jugador j WHERE j.id_jugador = :idJugador)")
    List<SesionEntrenamiento> findByJugadorId(@Param("idJugador") Integer idJugador);
}