package com.example.lab7.controller;


import com.example.lab7.entity.Technician;
import com.example.lab7.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

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

    @RequestMapping(value = "/edit")
    public String listarTecnicos(@ModelAttribute("product") Technician technician,
                                 Model model, @RequestParam("id") int id){

        Optional<Technician> optionalTechnician = tecnicoRepository.findById(id);
        if (optionalTechnician.isPresent()) {
            technician = optionalTechnician.get();
            model.addAttribute("tecnico", technician);
            return "tecnicos/form";
        } else {
            return "tecnicos/lista";
        }

    }
}
