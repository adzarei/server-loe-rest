package adzarei.loe.webfirma.controllers;


import adzarei.loe.webfirma.model.dto.ActaDto;
import adzarei.loe.webfirma.model.mappers.ActaMapper;
import adzarei.loe.webfirma.repository.ActaRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("webfirma/firma/acta")
public class FirmaActaController {

    private final ActaRepository actaRepository;
    private final ActaMapper mapper;

    public FirmaActaController(ActaRepository actaRepository, ActaMapper mapper) {
        this.actaRepository = actaRepository;
        this.mapper = mapper;
    }

    @RequestMapping("/{id}")
    public String getFirmaPage(@PathVariable Long id, Model model){

        ActaDto acta = mapper.actaToActaDto(actaRepository.findById(id).get());

        model.addAttribute("acta",acta);


        return "firmas/acta";
    }
}
