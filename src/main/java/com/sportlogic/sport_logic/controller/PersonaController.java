package com.sportlogic.sport_logic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sportlogic.sport_logic.model.Persona;
import com.sportlogic.sport_logic.service.PersonaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/personas")
public class PersonaController {

private final PersonaService personaService;

public PersonaController(PersonaService personaService) {
this.personaService = personaService;
}

@GetMapping
public String listar(Model model){

model.addAttribute("personas", personaService.listar());

return "personas";

}

@GetMapping("/nuevo")
public String nuevo(Model model){

model.addAttribute("persona", new Persona());

return "persona_form";

}

@PostMapping("/guardar")
public String guardar(@Valid@ModelAttribute Persona persona){

personaService.guardar(persona);

return "redirect:/personas";

}

@GetMapping("/editar/{id}")
public String editar(@PathVariable Integer id, Model model){

model.addAttribute("persona", personaService.buscarPorId(id));

return "persona_form";

}

@GetMapping("/eliminar/{id}")
public String eliminar(@PathVariable Integer id){

personaService.eliminar(id);

return "redirect:/personas";

}

}