package com.sportlogic.sport_logic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sportlogic.sport_logic.model.FichaMedica;
import com.sportlogic.sport_logic.model.Jugador;
import com.sportlogic.sport_logic.service.FichaMedicaService;
import com.sportlogic.sport_logic.service.JugadorService;
import com.sportlogic.sport_logic.service.PersonaService;
import com.sportlogic.sport_logic.service.UsuarioService; // 1. Importación necesaria

@Controller
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private FichaMedicaService fichaMedicaService;

    @GetMapping("")
    public String listarJugadores(Model model){
        model.addAttribute("jugadores", jugadorService.listarJugadores());
        return "jugadores";
    }

    @GetMapping("/nuevo")
    public String crearJugadorForm(Model model){
        model.addAttribute("jugador", new Jugador());
        model.addAttribute("personas", usuarioService.obtenerPersonasDeportistas()); 
        model.addAttribute("medicos", usuarioService.obtenerPersonasMedicos());
        return "formJugador";
    }

    @PostMapping("/guardar")
    public String guardarJugador(@ModelAttribute Jugador jugador) {
        Integer idPersona = jugador.getPersona().getId_persona();
        jugador.setPersona(personaService.obtenerPersonaPorId(idPersona));

        jugadorService.guardarJugador(jugador);
        return "redirect:/jugadores";
    }

    @GetMapping("/editar/{id}")
    public String editarJugadorForm(@PathVariable Integer id, Model model){
        model.addAttribute("jugador", jugadorService.obtenerJugador(id));
        // 4. CAMBIO CLAVE: También filtramos al editar para mantener la integridad
        model.addAttribute("personas", usuarioService.obtenerPersonasDeportistas());
        return "formJugador";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarJugador(@PathVariable Integer id){
        jugadorService.eliminarJugador(id);
        return "redirect:/jugadores";
    }

}