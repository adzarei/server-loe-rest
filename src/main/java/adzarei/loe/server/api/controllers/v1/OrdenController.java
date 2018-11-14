package adzarei.loe.server.api.controllers.v1;


import adzarei.loe.server.api.dtomodel.OrdenDto;
import adzarei.loe.server.api.services.OrdenService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(OrdenController.BASE_URL)
public class OrdenController {
    public static final String BASE_URL = "/api/v1/ordenes";
    private final OrdenService ordenService;

    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrdenDto> getOrdenesByActaId(@RequestParam Long actaid){
        return ordenService.getOrdenesByActaId(actaid);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewOrden(@RequestBody OrdenDto orden){
        ordenService.createNewOrden(orden);
    }

}
