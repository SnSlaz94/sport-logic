package com.sportlogic.sport_logic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sportlogic.sport_logic.model.Jugador;
import com.sportlogic.sport_logic.service.JugadorService;
import com.sportlogic.sport_logic.service.PersonaService;

@Controller
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public String listarJugadores(Model model){
        model.addAttribute("jugadores", jugadorService.listarJugadores());
        return "jugadores";
    }

    @GetMapping("/nuevo")
    public String crearJugadorForm(Model model){
        model.addAttribute("jugador", new Jugador());
        model.addAttribute("personas", personaService.listar()); // Lista de personas para asignar
        return "formJugador";
    }

    @PostMapping("/guardar")
    public String guardarJugador(@ModelAttribute Jugador jugador) {
        // Convertir el id enviado en un objeto Persona
        Integer idPersona = jugador.getPersona().getId_persona();
        jugador.setPersona(personaService.obtenerPersonaPorId(idPersona));

        jugadorService.guardarJugador(jugador);
        return "redirect:/jugadores";
    }

    @GetMapping("/editar/{id}")
    public String editarJugadorForm(@PathVariable Integer id, Model model){
        model.addAttribute("jugador", jugadorService.obtenerJugador(id));
        model.addAttribute("personas", personaService.listar());
        return "formJugador";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarJugador(@PathVariable Integer id){
        jugadorService.eliminarJugador(id);
        return "redirect:/jugadores";
    }
}