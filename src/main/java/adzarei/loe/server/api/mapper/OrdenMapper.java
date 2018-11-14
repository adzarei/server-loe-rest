package adzarei.loe.server.api.mapper;

import adzarei.loe.server.api.domain.Orden;
import adzarei.loe.server.api.dtomodel.OrdenDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrdenMapper {

    OrdenMapper INSTANCE = Mappers.getMapper(OrdenMapper.class);

    @Mapping(target = "id")
    OrdenDto ordenToOrdenDto(Orden orden);

    @Mapping(target = "numOrden")
    Orden ordenDtoToOrden(OrdenDto ordenDto);
}
