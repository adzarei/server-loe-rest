package adzarei.loe.server.services;

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

    @Mock
    LibroRepository libroRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        libroService = new LibroServiceImpl(libroRepository);
    }

    @Test
    public void getAllLibros() {

        //Given
        List<Libro> libros = Arrays.asList(new Libro(), new Libro(), new Libro());
        when(libroRepository.findAll()).thenReturn(libros);

        //When
        List<Libro> libros2 = libroService.getAllLibros();

        //Then
        assertEquals(3,libros2.size());
    }
}