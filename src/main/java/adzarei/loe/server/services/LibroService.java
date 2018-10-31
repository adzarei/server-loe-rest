package adzarei.loe.server.services;

import adzarei.loe.server.api.v1.model.LibroDto;

import java.util.List;

public interface LibroService {

    List<LibroDto> getAllLibros();

    LibroDto getLibroById(Long id);

    LibroDto getLibroByNumLibro(String numLibro);

    LibroDto createNewLibro(LibroDto libroDto);

    void deleteLibro(Long id);

    void patchLibro(Long id, LibroDto libroDto);

    void updateOrCreateLibro(Long id, LibroDto libroDto);
}
