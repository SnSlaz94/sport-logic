package com.sportlogic.sport_logic.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sportlogic.sport_logic.model.Usuario;
import com.sportlogic.sport_logic.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

private final UsuarioRepository usuarioRepository;

public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
this.usuarioRepository = usuarioRepository;
}

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

Usuario usuario = usuarioRepository.findByUsername(username)
.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

return User.builder()
.username(usuario.getUsername())
.password(usuario.getPassword())
.roles(usuario.getRol().getNombre_rol())
.build();

}

}