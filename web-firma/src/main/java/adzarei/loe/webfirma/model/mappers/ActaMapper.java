package adzarei.loe.webfirma.model.mappers;


import adzarei.loe.webfirma.model.dto.ActaDto;
import adzarei.loe.webfirma.model.server.Acta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActaMapper {

    ActaMapper INSTANCE = Mappers.getMapper(ActaMapper.class);
    @Mappings({
            @Mapping(source = "libro.id", target = "libroId"),
            @Mapping(source = "ordenes",target = "ordenes")
    })
    ActaDto actaToActaDto(Acta acta);

    @Mapping(target = "numHoja")
    Acta actaDtoToActa(ActaDto actaDto);



}
