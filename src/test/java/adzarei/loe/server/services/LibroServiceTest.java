package adzarei.loe.server.services;

import adzarei.loe.server.api.v1.mapper.LibroMapper;
import adzarei.loe.server.api.v1.model.LibroDto;
import adzarei.loe.server.domain.Libro;
import adzarei.loe.server.respositories.LibroRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class LibroServiceTest {

    LibroService libroService;
    LibroMapper libroMapper;

    @Mock
    LibroRepository libroRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        libroService = new LibroServiceImpl(libroRepository,LibroMapper.INSTANCE);
    }

    @Test
    public void getAllLibros() {

        //Given
        List<Libro> libros = Arrays.asList(new Libro(), new Libro(), new Libro());
        when(libroRepository.findAll()).thenReturn(libros);

        //When
        List<LibroDto> libroDto = libroService.getAllLibros();

        //Then
        assertEquals(3,libroDto.size());
    }
}