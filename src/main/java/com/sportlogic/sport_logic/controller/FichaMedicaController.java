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
import com.sportlogic.sport_logic.service.FichaMedicaService;
import com.sportlogic.sport_logic.service.JugadorService;
import com.sportlogic.sport_logic.service.MedicoService;

@Controller
@RequestMapping("/fichas")
public class FichaMedicaController {

    @Autowired
    private FichaMedicaService fichaService;

    @Autowired
    private JugadorService jugadorService;

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public String listarFichas(Model model){
        model.addAttribute("fichas", fichaService.listarFichas());
        return "fichas";
    }

    @GetMapping("/nuevo")
    public String crearFichaForm(Model model){
        model.addAttribute("ficha", new FichaMedica());
        model.addAttribute("deportistas", jugadorService.listarJugadores());
        model.addAttribute("medicos", medicoService.listarMedicos());
        return "formFicha";
    }

    @PostMapping("/guardar")
    public String guardarFicha(@ModelAttribute FichaMedica ficha){
        fichaService.guardarFicha(ficha);
        return "redirect:/fichas";
    }

    @GetMapping("/editar/{id}")
    public String editarFichaForm(@PathVariable Integer id, Model model){
        model.addAttribute("ficha", fichaService.obtenerFicha(id));
        model.addAttribute("deportistas", jugadorService.listarJugadores());
        model.addAttribute("medicos", medicoService.listarMedicos());
        return "formFicha";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFicha(@PathVariable Integer id){
        fichaService.eliminarFicha(id);
        return "redirect:/fichas";
    }
}