package com.sportlogic.sport_logic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportlogic.sport_logic.model.Rol;
import com.sportlogic.sport_logic.repository.RolRepository;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    // Listar todos los roles
    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }

    // Obtener un rol por id
    public Rol obtenerRolPorId(int id) {
        return rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }

    // Guardar o actualizar un rol
    public Rol guardarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    // Eliminar un rol
    public void eliminarRol(int id) {
        rolRepository.deleteById(id);
    }
}