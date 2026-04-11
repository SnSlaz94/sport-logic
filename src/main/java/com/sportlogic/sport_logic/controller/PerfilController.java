package com.sportlogic.sport_logic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sportlogic.sport_logic.model.FichaMedica;
import com.sportlogic.sport_logic.model.Jugador;
import com.sportlogic.sport_logic.model.Usuario;
import com.sportlogic.sport_logic.repository.FichaMedicaRepository;
import com.sportlogic.sport_logic.repository.JugadorRepository;
import com.sportlogic.sport_logic.repository.UsuarioRepository;

@Controller
public class PerfilController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private FichaMedicaRepository fichaMedicaRepository;

    // Esta ruta sirve para ver el perfil propio o de un jugador específico por ID
    @GetMapping({"/perfil", "/jugadores/perfil/{id}"})
    public String verPerfil(@PathVariable(name = "id", required = false) Integer id, Authentication auth, Model model) {
        
        Jugador jugador = null;
        Usuario usuario = null;

        if (id != null) {
            // Si hay un ID en la URL, buscamos ese jugador específicamente
            jugador = jugadorRepository.findById(id).orElse(null);
            if (jugador != null && jugador.getPersona() != null) {
                usuario = jugador.getPersona().getUsuario();
            }
        } else if (auth != null) {
            // Si no hay ID, buscamos por la sesión activa
            String username = auth.getName();
            usuario = usuarioRepository.findByUsername(username).orElse(null);
            if (usuario != null && usuario.getPersona() != null) {
                jugador = jugadorRepository.findByPersona(usuario.getPersona());
            }
        }

        // Pasamos los datos al modelo solo si existen
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            model.addAttribute("persona", usuario.getPersona());
        }

        if (jugador != null) {
            model.addAttribute("jugador", jugador);
            // IMPORTANTE: Usamos findByJugadorId que definimos en el repositorio para evitar errores de tipos
            FichaMedica ficha = fichaMedicaRepository.findByJugadorId(jugador.getId_jugador());
            model.addAttribute("ficha", ficha);
        }

        return "perfil";
    }
}