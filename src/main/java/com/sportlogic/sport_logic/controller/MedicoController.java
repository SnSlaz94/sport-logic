package com.sportlogic.sport_logic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sportlogic.sport_logic.model.Medico;
import com.sportlogic.sport_logic.service.MedicoService;
import com.sportlogic.sport_logic.service.PersonaService;
import com.sportlogic.sport_logic.service.UsuarioService;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private PersonaService personaService;
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listarMedicos(Model model){
        model.addAttribute("medicos", medicoService.listarMedicos());
        return "medicos";
    }

    @GetMapping("/nuevo")
    public String crearMedicoForm(Model model){

        model.addAttribute("medico", new Medico());
        model.addAttribute("personasMedicos", usuarioService.obtenerPersonasMedicos());

        return "formMedico";
    }

    @PostMapping("/guardar")
    public String guardarMedico(@ModelAttribute Medico medico){
        medicoService.guardarMedico(medico);
        return "redirect:/medicos";
    }

    @GetMapping("/editar/{id}")
    public String editarMedicoForm(@PathVariable Integer id, Model model){

        model.addAttribute("medico", medicoService.obtenerMedico(id));
        model.addAttribute("personasMedicos", usuarioService.obtenerPersonasMedicos());

        return "formMedico";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMedico(@PathVariable Integer id){
        medicoService.eliminarMedico(id);
        return "redirect:/medicos";
    }
}