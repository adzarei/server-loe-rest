package adzarei.loe.webfirma.model.mappers;


import adzarei.loe.webfirma.model.dto.LibroDto;
import adzarei.loe.webfirma.model.server.Libro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LibroMapper {

    LibroMapper INSTANCE = Mappers.getMapper(LibroMapper.class);

    @Mapping(target = "id")
    LibroDto libroToLibroDTto(Libro libro);

    @Mapping(target = "id")
    Libro libroDtoToLibro(LibroDto libroDto);


}
