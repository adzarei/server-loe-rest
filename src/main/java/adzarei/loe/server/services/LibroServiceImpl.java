package adzarei.loe.server.services;

import adzarei.loe.server.api.v1.mapper.LibroMapper;
import adzarei.loe.server.api.v1.model.LibroDto;
import adzarei.loe.server.domain.Libro;
import adzarei.loe.server.respositories.LibroRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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

    @Override
    public LibroDto getLibroById(Long id) {
        return libroRepository.findById(id)
                .map(libroMapper::libroToLibroDTto)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public LibroDto getLibroByNumLibro(String numLibro) {
        throw new NotImplementedException();
    }


    @Override
    public LibroDto createNewLibro(LibroDto libroDto) {
        Libro libro = libroMapper.libroDtoToLibro(libroDto);
        libro = libroRepository.save(libro);

        return libroMapper.libroToLibroDTto(libro);
    }

    @Override
    public void deleteLibro(Long id) {

    }

    @Override
    public void patchLibro(Long id,LibroDto libroDto) {

        libroRepository.findById(id).map(libro -> {
            if(libroDto.getAyto() != null){
                libro.setAyto(libroDto.getAyto());
            }

            if(libroDto.getCAE() != null){
                libro.setCAE(libroDto.getCAE());
            }
            if(libroDto.getFAutorizacion() != null){
                libro.setFAutorizacion(libroDto.getFAutorizacion());
            }
            if(libroDto.getFCAE() != null){
                libro.setFCAE(libroDto.getFCAE());
            }
            if(libroDto.getFFinObra() != null){
                libro.setFFinObra(libroDto.getFFinObra());
            }
            if(libroDto.getFInicioObra() != null){
                libro.setFInicioObra(libroDto.getFInicioObra());
            }
            if(libroDto.getFLicencia() != null){
                libro.setFLicencia(libroDto.getFLicencia());
            }
            if(libroDto.getNumExpColegio() != null){
                libro.setNumExpColegio(libroDto.getNumExpColegio());
            }
            if(libroDto.getNumlibro() != null){
                libro.setNumlibro(libroDto.getNumlibro());
            }
            if(libroDto.getNumLicencia() != null){
                libro.setNumLicencia(libroDto.getNumLicencia());
            }
            if(libroDto.getObra() != null){
                libro.setObra(libroDto.getObra());
            }
            if(libroDto.getSituacion() != null){
                libro.setSituacion(libroDto.getSituacion());
            }
                return libroRepository.save(libro);
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void updateOrCreateLibro(Long id, LibroDto libroDto) {
        //TODO: find librobyid and update if present.
        libroRepository.save(libroMapper.libroDtoToLibro(libroDto));
    }
}
