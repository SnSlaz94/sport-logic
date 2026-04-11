package com.sportlogic.sport_logic.repository;

import com.sportlogic.sport_logic.model.Persona;
import com.sportlogic.sport_logic.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    Optional<Usuario> findByUsername(String username);

    @Query("SELECT u.persona FROM Usuario u WHERE u.rol.nombre_rol = 'Medico'")
    List<Persona> obtenerPersonasMedicos();

    @Query("SELECT u FROM Usuario u JOIN u.rol r WHERE UPPER(r.nombre_rol) = 'MEDICO'")
    public List<Usuario> obtenerUsuariosMedicos();

    @Query("SELECT u.persona FROM Usuario u WHERE u.rol.nombre_rol = 'Deportista'")
    List<Persona> obtenerPersonasDeportistas();
    
    @Query("SELECT u FROM Usuario u JOIN u.rol r WHERE UPPER(r.nombre_rol) = 'DEPORTISTA'")
    public List<Usuario> obtenerUsuariosDeportistas();

    @Query("SELECT u FROM Usuario u WHERE u.persona.id_persona = :idPersona")
    Usuario findByPersonaId(@Param("idPersona") Integer idPersona);
}