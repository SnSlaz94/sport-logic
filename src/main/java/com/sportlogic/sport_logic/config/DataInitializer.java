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

        // 1. Crear rol administrador si no existe
        Rol adminRol = rolRepository.findById(1).orElse(null);
        if (adminRol == null) {
            adminRol = new Rol();
            adminRol.setNombre_rol("Administrador");
            adminRol = rolRepository.save(adminRol);
            System.out.println("Rol administrador creado");
        }

        // 2. Crear superusuario si no existe
        if (!usuarioRepository.findByUsername("superadmin").isPresent()) {
            Persona persona = new Persona();
            persona.setNombre("Super");
            persona.setApellido("Admin");
            persona.setDocumento("00000000");
            persona.setFecha_nacimiento(java.time.LocalDate.of(1990, 1, 1));
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
            System.out.println("Superusuario creado: superadmin / admin123");
        } else {
            System.out.println("Superusuario ya existe");
        }
    }
}