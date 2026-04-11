package com.sportlogic.sport_logic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;


@Controller
public class InicioController {

@GetMapping("/")
public String raiz() {
return "redirect:/login";
}

@GetMapping("/inicio")
public String inicio(Model model, Authentication authentication) {
    // Esto asegura que la vista siempre tenga el rol actual para evaluar las condiciones
    if (authentication != null) {
        String rol = authentication.getAuthorities().toString();
        model.addAttribute("rolActual", rol);
    }
    return "inicio";
}
}