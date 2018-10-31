package adzarei.loe.server.services;

import adzarei.loe.server.api.v1.mapper.LibroMapper;
import adzarei.loe.server.api.v1.model.LibroDto;
import adzarei.loe.server.domain.Libro;
import adzarei.loe.server.respositories.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;
    private final LibroMapper libroMapper;

    public LibroServiceImpl(LibroRepository libroRepository, LibroMapper libroMapper) {
        this.libroRepository = libroRepository;
        this.libroMapper = libroMapper;
    }

    @Override
    public List<LibroDto> getAllLibros() {

        //System.out.println("Libros en repo:" + libroRepository.findAll().size());

        return libroRepository.findAll()
                .stream()
                .map(libroMapper::libroToLibroDTto)
                .collect(Collectors.toList());
    }
}
