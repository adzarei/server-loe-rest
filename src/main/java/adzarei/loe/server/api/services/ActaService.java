package adzarei.loe.server.api.services;

import adzarei.loe.server.api.domain.Acta;
import adzarei.loe.server.api.dtomodel.ActaDto;

import java.util.List;

public interface ActaService {

    List<ActaDto> getActasByLibroId(Long id);

    int getNextNumHoja(Long id);

    ActaDto getActaById(Long id);
}
