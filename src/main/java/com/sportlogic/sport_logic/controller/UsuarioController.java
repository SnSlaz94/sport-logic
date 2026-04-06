package com.sportlogic.sport_logic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sportlogic.sport_logic.model.Usuario;
import com.sportlogic.sport_logic.service.PersonaService;
import com.sportlogic.sport_logic.service.RolService;
import com.sportlogic.sport_logic.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private RolService rolService;

    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "usuarios";
    }

    @GetMapping("/nuevo")
    public String crearUsuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("personas", personaService.listar());
        model.addAttribute("roles", rolService.listarRoles());
        return "formUsuario";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.guardarUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuarioForm(@PathVariable int id, Model model) {
        model.addAttribute("usuario", usuarioService.obtenerUsuarioPorId(id));
        model.addAttribute("personas", personaService.listar());
        model.addAttribute("roles", rolService.listarRoles());
        return "formUsuario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable int id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
}