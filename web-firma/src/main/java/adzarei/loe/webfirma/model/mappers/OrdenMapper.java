package adzarei.loe.webfirma.model.mappers;


import adzarei.loe.webfirma.model.dto.OrdenDto;
import adzarei.loe.webfirma.model.server.Orden;
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
