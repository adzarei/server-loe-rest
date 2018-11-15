package adzarei.loe.webfirma.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("webfirma/firma/libro")
public class FirmaLibroController {


    @RequestMapping("/{id}")
    public String getFirmaPage(){

        return "firmas/acta/index";
    }

}
