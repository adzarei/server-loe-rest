package adzarei.loe.server.api.mapper;

import adzarei.loe.server.api.dtomodel.LibroDto;
import adzarei.loe.server.api.domain.Libro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LibroMapper {

    LibroMapper INSTANCE = Mappers.getMapper(LibroMapper.class);

    @Mapping(source = "id",target = "id")
    LibroDto libroToLibroDTto(Libro libro);

    @Mapping(source = "id", target = "id")
    Libro libroDtoToLibro(LibroDto libroDto);


}
