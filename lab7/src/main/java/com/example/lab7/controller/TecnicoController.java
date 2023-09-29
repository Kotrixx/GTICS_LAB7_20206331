package com.example.lab7.controller;


import com.example.lab7.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/tecnico")
public class TecnicoController {

    @Autowired
    TecnicoRepository tecnicoRepository;

    @RequestMapping(value = "")
    public String listarTecnicos(Model model){
        model.addAttribute("listaTecnicos",tecnicoRepository.findAll());
        return "tecnicos/lista";
    }
}
