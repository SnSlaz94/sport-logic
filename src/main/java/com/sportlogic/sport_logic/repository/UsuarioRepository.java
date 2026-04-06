package com.sportlogic.sport_logic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportlogic.sport_logic.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

Optional<Usuario> findByUsername(String username);
Optional<Usuario> findByEmail(String email);

}
