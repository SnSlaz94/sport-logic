package com.sportlogic.sport_logic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportlogic.sport_logic.model.Medico;
import com.sportlogic.sport_logic.repository.MedicoRepository;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> listarMedicos(){
        return medicoRepository.findAll();
    }

    public Medico guardarMedico(Medico medico){
        return medicoRepository.save(medico);
    }

    public Medico obtenerMedico(Integer id){
        return medicoRepository.findById(id).orElse(null);
    }

    public void eliminarMedico(Integer id){
        medicoRepository.deleteById(id);
    }
}