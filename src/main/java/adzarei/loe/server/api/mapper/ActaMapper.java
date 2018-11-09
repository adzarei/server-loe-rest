package adzarei.loe.server.api.mapper;

import adzarei.loe.server.api.domain.Acta;
import adzarei.loe.server.api.dtomodel.ActaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActaMapper {

    ActaMapper INSTANCE = Mappers.getMapper(ActaMapper.class);

    @Mapping( target = "numHoja")
    ActaDto actaToActaDto(Acta acta);

    @Mapping(target = "numHoja")
    Acta actaDtoToActa(ActaDto actaDto);



}
