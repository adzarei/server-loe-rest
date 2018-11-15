package adzarei.loe.webfirma.controllers;

import adzarei.loe.server.api.dtomodel.ActaDto;

import adzarei.loe.server.api.services.ActaServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("webfirma/firma/acta")
public class FirmaActaController {

    private final ActaServiceImpl actaService;

    public FirmaActaController(ActaServiceImpl actaService) {
        this.actaService = actaService;
    }

    @RequestMapping("/{id}")
    public String getFirmaPage(@PathVariable Long id, Model model){

        ActaDto acta = actaService.getActaById(id);

        model.addAttribute("acta",acta);


        return "firmas/acta";
    }
}
