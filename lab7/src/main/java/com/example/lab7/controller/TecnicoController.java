package com.example.lab7.controller;


import com.example.lab7.entity.Technician;
import com.example.lab7.repository.TecnicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String editarTecnico(@ModelAttribute("product") Technician technician,
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
    @RequestMapping(value = "/nuevo")
    public String nuevoTecnico(@ModelAttribute("tecnico") Technician technician){

        return "tecnicos/form";
    }
    @PostMapping("/guardar")
    public String guardarProducto(RedirectAttributes attributes, Model model,
                                  @ModelAttribute("tecnico") @Valid Technician technician, BindingResult bindingResult) {
        model.addAttribute("tecnico", technician);

        if (!bindingResult.hasErrors()) { //si no hay errores, se realiza el flujo normal
            /*if (product.getProductname().equals("gaseosa")) {
                model.addAttribute("msg", "Error al crear producto");
                model.addAttribute("listaCategorias", categoryRepository.findAll());
                model.addAttribute("listaProveedores", supplierRepository.findAll());
                return "product/editFrm";
            } else {
                if (product.getId() == 0) {
                    attr.addFlashAttribute("msg", "Producto creado exitosamente");
                } else {
                    attr.addFlashAttribute("msg", "Producto actualizado exitosamente");
                }
                productRepository.save(product);
                return "redirect:/product";
            }*/
            if(technician.getFirstName().matches("^[a-zA-Z]+$")){

            }
            if (technician.getId() == 0) {
                attributes.addFlashAttribute("msg", "Tecnico creado exitosamente");
            } else {
                attributes.addFlashAttribute("msg", "Tecnico actualizado exitosamente");
            }
            tecnicoRepository.save(technician);
            return "redirect:/tecnico";

        } else { //hay al menos 1 error
            return "tecnicos/form";
        }
    }
}
