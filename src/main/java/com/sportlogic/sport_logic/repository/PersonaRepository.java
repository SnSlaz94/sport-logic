package com.sportlogic.sport_logic.repository;

import com.sportlogic.sport_logic.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    @Query("SELECT p FROM Persona p JOIN p.usuario u JOIN u.rol r WHERE UPPER(r.nombre_rol) = 'DEPORTISTA'")
    List<Persona> obtenerSoloDeportistas();

    @Query("SELECT p FROM Persona p JOIN p.usuario u JOIN u.rol r WHERE UPPER(r.nombre_rol) = 'MEDICO'")
    List<Persona> obtenerSoloMedicos();
}