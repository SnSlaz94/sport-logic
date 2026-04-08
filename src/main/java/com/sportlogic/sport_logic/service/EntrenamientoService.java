package com.sportlogic.sport_logic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportlogic.sport_logic.model.Horario;
import com.sportlogic.sport_logic.model.SesionEntrenamiento;
import com.sportlogic.sport_logic.repository.HorarioRepository;
import com.sportlogic.sport_logic.repository.SesionEntrenamientoRepository;

@Service
public class EntrenamientoService {

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private SesionEntrenamientoRepository sesionRepository;

    /* ================= HORARIOS ================= */

    public List<Horario> listarHorarios(){
        return horarioRepository.findAll();
    }

    @SuppressWarnings("null")
    public Horario guardarHorario(Horario horario){
        return horarioRepository.save(horario);
    }

    @SuppressWarnings("null")
    public void eliminarHorario(Integer id){
        horarioRepository.deleteById(id);
    }

    public Horario obtenerHorarioPorId(Integer id){
        return horarioRepository.findById(id).orElse(null); // Para editar
    }

    /* ================= SESIONES ================= */

    public List<SesionEntrenamiento> listarSesiones(){
        return sesionRepository.findAll();
    }

    public SesionEntrenamiento guardarSesion(SesionEntrenamiento sesion){
        return sesionRepository.save(sesion);
    }

    public void eliminarSesion(Integer id){
        sesionRepository.deleteById(id);
    }

    public SesionEntrenamiento obtenerSesion(Integer id){
    return sesionRepository.findById(id).orElse(null);
    }
}