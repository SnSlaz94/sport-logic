package com.sportlogic.sport_logic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportlogic.sport_logic.model.Jugador;
import com.sportlogic.sport_logic.repository.JugadorRepository;

@Service
public class JugadorService {

@Autowired
private JugadorRepository jugadorRepository;

    public List<Jugador> listarJugadores() {
    return jugadorRepository.findAll();
}

public Jugador guardarJugador(Jugador jugador){
    return jugadorRepository.save(jugador);
}

public Jugador obtenerJugador(Integer id){

Optional<Jugador> jugador = jugadorRepository.findById(id);

return jugador.orElse(null);

}

public void eliminarJugador(Integer id){
    jugadorRepository.deleteById(id);
}

public Jugador findById(Integer id) {
    // Usamos el repositorio para buscar al futbolista por su ID
    return jugadorRepository.findById(id).orElse(null);
}

}
