package adzarei.loe.server.api.controllers.v1;

import adzarei.loe.server.api.dtomodel.AgenteDto;
import adzarei.loe.server.api.services.AgenteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(AgenteController.BASE_URL)
public class AgenteController {
    public static final String BASE_URL = "/api/v1/agentes";
    private final AgenteService agenteService;

    public AgenteController(AgenteService agenteService) {
        this.agenteService = agenteService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AgenteDto> getAgentesByLibroId(@RequestParam Long libroid){
        return agenteService.getAgentesByLibroId(libroid);
    }
}
