package com.sportlogic.sport_logic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sportlogic.sport_logic.model.Persona;
import com.sportlogic.sport_logic.model.Usuario;
import com.sportlogic.sport_logic.repository.UsuarioRepository;



@Service
public class UsuarioService {
    private static UsuarioRepository usuarioRepository;
    

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        UsuarioService.usuarioRepository = usuarioRepository;
    }
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario guardarUsuario(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public Usuario obtenerUsuarioPorId(int id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void eliminarUsuario(int id) {
        usuarioRepository.deleteById(id);
    }

    public static List<Usuario> obtenerUsuariosDeportistas() {
        return usuarioRepository.findAll();
    }

    public List<Persona> obtenerPersonasMedicos() {
        return usuarioRepository.obtenerPersonasMedicos();
    }
    public List<Usuario> obtenerPersonasDeportistas() {
    return usuarioRepository.obtenerUsuariosDeportistas(); 
    }

    public Usuario obtenerUsuarioPorPersona(Integer idPersona) {
    return usuarioRepository.findByPersonaId(idPersona);
}
}