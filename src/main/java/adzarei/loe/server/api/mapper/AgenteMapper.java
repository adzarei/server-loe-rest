package adzarei.loe.server.api.mapper;

import adzarei.loe.server.api.domain.Agente;
import adzarei.loe.server.api.dtomodel.AgenteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AgenteMapper {

    AgenteMapper INSTANCE = Mappers.getMapper(AgenteMapper.class);

    @Mapping(target = "idFiscal")
    AgenteDto agenteToAgenteDto(Agente agente);

    @Mapping(target = "idFiscal")
    Agente agenteDtoToAgente(AgenteDto agenteDto);

}
