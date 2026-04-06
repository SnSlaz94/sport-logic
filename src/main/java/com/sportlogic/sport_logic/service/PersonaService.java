package com.sportlogic.sport_logic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportlogic.sport_logic.model.Persona;
import com.sportlogic.sport_logic.repository.PersonaRepository;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    // Listar todas las personas
    public List<Persona> listar() {
        return personaRepository.findAll();
    }

    // Obtener persona por ID
    public Persona obtenerPersonaPorId(Integer id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    // Guardar o actualizar persona
    public Persona guardar(Persona persona) {
        return personaRepository.save(persona);
    }

    // Eliminar persona
    public void eliminar(Integer id) {
        personaRepository.deleteById(id);
    }

    // Buscar persona por ID (retorna null si no existe)
    public Persona buscarPorId(Integer id) {
        Optional<Persona> persona = personaRepository.findById(id);
        return persona.orElse(null);
    }
}