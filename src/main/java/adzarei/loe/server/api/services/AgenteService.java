package adzarei.loe.server.api.services;

import adzarei.loe.server.api.domain.Agente;
import adzarei.loe.server.api.dtomodel.AgenteDto;

import java.util.List;

public interface AgenteService {

    List<AgenteDto> getAgentesByLibroId(Long id);

}
