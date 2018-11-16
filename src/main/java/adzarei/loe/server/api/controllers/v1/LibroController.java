package adzarei.loe.server.api.controllers.v1;

import adzarei.loe.server.api.dtomodel.LibroDto;
import adzarei.loe.server.api.services.LibroService;
import adzarei.loe.server.security.firma.KeyTool;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.security.cert.Certificate;

import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(LibroController.BASE_URL)
public class LibroController {

    public static final String BASE_URL = "/api/v1/libros";
    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LibroDto> getListOfLibros() throws Exception {

        KeyTool keyTool = new KeyTool();
        keyTool.generateCertificate();

        return libroService.getAllLibros();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public LibroDto getLibroById(@PathVariable Long id){
        return libroService.getLibroById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createLibro(@RequestBody LibroDto libroDto){
        libroService.createNewLibro(libroDto);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchLibro(@PathVariable Long id, @RequestBody LibroDto libroDto){
        libroService.patchLibro(id,libroDto);
    }

    @PutMapping({"{id}"})
    @ResponseStatus(HttpStatus.CREATED)
    public void updateLibro(@PathVariable Long id, @RequestBody LibroDto libroDto){
        //TODO: if id not exists --> CREATED 201 else update object and return NO_CONTENT 204
        libroService.updateOrCreateLibro(id, libroDto);
    }

}
