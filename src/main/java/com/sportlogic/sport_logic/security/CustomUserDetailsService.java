package com.sportlogic.sport_logic.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportlogic.sport_logic.model.Usuario;
import com.sportlogic.sport_logic.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional(readOnly = true) // Garantiza una sesión de base de datos estable para leer el Rol
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario: " + username + " no encontrado"));

        // Verificamos que el usuario tenga un rol asignado para evitar NullPointerException
        if (usuario.getRol() == null) {
            throw new UsernameNotFoundException("El usuario no tiene un rol asignado");
        }

        // Importante: El método .roles() de Spring Security ya añade el prefijo "ROLE_" 
        // internamente. Si tu base de datos tiene "ADMIN", Spring lo tratará como "ROLE_ADMIN".
        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(usuario.getRol().getNombre_rol()) // Usamos el nombre ajustado en el modelo
                .build();
    }
}