package com.sportlogic.sport_logic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sportlogic.sport_logic.model.Horario;
import com.sportlogic.sport_logic.model.SesionEntrenamiento;
import com.sportlogic.sport_logic.service.EntrenamientoService;

@Controller
public class EntrenamientoController {

    @Autowired
    private EntrenamientoService entrenamientoService;

    /* ================= PAGINA PRINCIPAL ================= */
    @GetMapping("/entrenamientos")
    public String paginaEntrenamientos(Model model) {
        model.addAttribute("horariosCount", entrenamientoService.listarHorarios().size());
        model.addAttribute("sesionesCount", entrenamientoService.listarSesiones().size());
        return "entrenamientos"; // apunta a entrenamientos.html
    }

    /* ================= HORARIOS ================= */

    @GetMapping("/horarios")
    public String listarHorarios(Model model){
        model.addAttribute("horarios", entrenamientoService.listarHorarios());
        return "horarios";
    }

    @GetMapping("/horarios/nuevo")
    public String nuevoHorario(Model model){
        model.addAttribute("horario", new Horario());
        return "formHorario";
    }

    @GetMapping("/horarios/editar/{id}")
    public String editarHorario(@PathVariable Integer id, Model model){
        Horario horario = entrenamientoService.obtenerHorarioPorId(id);
        model.addAttribute("horario", horario);
        return "formHorario"; // Reutiliza el mismo formulario para crear/editar
    }

    @PostMapping("/horarios/guardar")
    public String guardarHorario(@ModelAttribute Horario horario){
        entrenamientoService.guardarHorario(horario);
        return "redirect:/horarios";
    }

    @GetMapping("/horarios/eliminar/{id}")
    public String eliminarHorario(@PathVariable Integer id){
        entrenamientoService.eliminarHorario(id);
        return "redirect:/horarios";
    }

    /* ================= SESIONES ================= */

    @GetMapping("/sesiones")
    public String listarSesiones(Model model){
        model.addAttribute("sesiones", entrenamientoService.listarSesiones());
        return "sesiones";
    }

    @GetMapping("/sesiones/nuevo")
    public String nuevaSesion(Model model){
        model.addAttribute("sesion", new SesionEntrenamiento());
        model.addAttribute("horarios", entrenamientoService.listarHorarios());
        return "formSesion";
    }

    @GetMapping("/sesiones/editar/{id}")
    public String editarSesion(@PathVariable Integer id, Model model){
        SesionEntrenamiento sesion = entrenamientoService.obtenerSesion(id);
        model.addAttribute("sesion", sesion);
        model.addAttribute("horarios", entrenamientoService.listarHorarios());
        return "formSesion"; // Reutiliza el mismo formulario para crear/editar
    }

    @PostMapping("/sesiones/guardar")
    public String guardarSesion(@ModelAttribute SesionEntrenamiento sesion){
        entrenamientoService.guardarSesion(sesion);
        return "redirect:/sesiones";
    }

    @GetMapping("/sesiones/eliminar/{id}")
    public String eliminarSesion(@PathVariable Integer id){
        entrenamientoService.eliminarSesion(id);
        return "redirect:/sesiones";
    }
}