package adzarei.loe.server.services;

import adzarei.loe.server.domain.Libro;
import adzarei.loe.server.respositories.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }
}
