package com.sportlogic.sport_logic.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sportlogic.sport_logic.model.Persona;
import com.sportlogic.sport_logic.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

    @Query("SELECT u.persona FROM Usuario u WHERE u.rol.nombre_rol = 'MEDICO'")
List<Persona> obtenerPersonasMedicos();

Optional<Usuario> findByUsername(String username);
Optional<Usuario> findByEmail(String email);

}
