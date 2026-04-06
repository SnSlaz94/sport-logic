package com.sportlogic.sport_logic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sportlogic.sport_logic.model.Usuario;
import com.sportlogic.sport_logic.repository.FichaMedicaRepository;
import com.sportlogic.sport_logic.repository.JugadorRepository;
import com.sportlogic.sport_logic.repository.UsuarioRepository;

@Controller
public class PerfilController {

@Autowired
UsuarioRepository usuarioRepository;

@Autowired
JugadorRepository jugadorRepository;

@Autowired
FichaMedicaRepository fichaMedicaRepository;

@GetMapping("/mi-perfil")
public String verPerfil(Authentication auth, Model model) {

    String username = auth.getName();

    Usuario usuario = usuarioRepository.findByUsername(username).orElse(null);

    model.addAttribute("usuario", usuario);

    if(usuario != null && usuario.getPersona() != null){

        var jugador = jugadorRepository.findByPersona(usuario.getPersona());
        model.addAttribute("jugador", jugador);

        if(jugador != null){
            var ficha = fichaMedicaRepository.findByJugador(jugador);
            model.addAttribute("ficha", ficha);
        }

    }

    return "perfil";
}

}