package adzarei.loe.server.controllers.v1;

import adzarei.loe.server.api.v1.model.LibroDto;
import adzarei.loe.server.services.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(LibroController.BASE_URL)
public class LibroController {

    public static final String BASE_URL = "/api/v1/libros";
    public final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LibroDto> getListOfLibros(){
        return libroService.getAllLibros();
    }
}
