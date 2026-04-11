package com.sportlogic.sport_logic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportlogic.sport_logic.model.FichaMedica;
import com.sportlogic.sport_logic.repository.FichaMedicaRepository;

@Service
public class FichaMedicaService {

    @Autowired
    private FichaMedicaRepository fichaMedicaRepository;

    public List<FichaMedica> listarFichas(){
        return fichaMedicaRepository.findAll();
    }

    public FichaMedica guardarFicha(FichaMedica ficha){
        return fichaMedicaRepository.save(ficha);
    }

    public FichaMedica obtenerFicha(Integer id){
        return fichaMedicaRepository.findById(id).orElse(null);
    }

    public void eliminarFicha(Integer id){
        fichaMedicaRepository.deleteById(id);
    }
    public FichaMedica obtenerFichaPorJugador(Integer idJugador) {
    return fichaMedicaRepository.findByJugadorId(idJugador);
    }

    public FichaMedica findByJugadorId(Integer id) {
    return fichaMedicaRepository.findByJugadorId(id);
    }   
}