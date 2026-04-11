package com.sportlogic.sport_logic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import com.sportlogic.sport_logic.model.Persona;
import com.sportlogic.sport_logic.model.Rol;
import com.sportlogic.sport_logic.model.Usuario;
import com.sportlogic.sport_logic.repository.PersonaRepository;
import com.sportlogic.sport_logic.repository.RolRepository;
import com.sportlogic.sport_logic.repository.UsuarioRepository;
import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // 1. Crear rol administrador
        Rol adminRol = rolRepository.buscarPorNombre("ADMIN").orElseGet(() -> {
        Rol newRol = new Rol();
        newRol.setNombre_rol("ADMIN"); // Mantiene tu estándar de BD
        return rolRepository.save(newRol);
    });

        // 2. Crear superusuario
        if (!usuarioRepository.findByUsername("superadmin").isPresent()) {
            Persona persona = new Persona();
            persona.setNombre("Super");
            persona.setApellido("Admin");
            persona.setDocumento("00000000");
            // Aquí ya no dará error porque Persona usa LocalDate
            persona.setFecha_nacimiento(LocalDate.of(2000, 1, 1)); 
            persona.setTelefono("3001234567");
            persona.setDireccion("Dirección Admin");
            persona = personaRepository.save(persona);

            Usuario usuario = new Usuario();
            usuario.setUsername("superadmin");
            usuario.setPassword(passwordEncoder.encode("admin123"));
            usuario.setEmail("superadmin@email.com");
            usuario.setPersona(persona);
            usuario.setRol(adminRol);

            usuarioRepository.save(usuario);
        }
    }
}