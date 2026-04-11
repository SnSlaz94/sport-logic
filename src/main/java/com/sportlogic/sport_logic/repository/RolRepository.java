package com.sportlogic.sport_logic.repository;

import com.sportlogic.sport_logic.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    
    @Query("SELECT r FROM Rol r WHERE r.nombre_rol = :nombre")
    Optional<Rol> buscarPorNombre(@Param("nombre") String nombre);
}