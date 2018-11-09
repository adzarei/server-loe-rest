package adzarei.loe.server.api.services;

import adzarei.loe.server.api.dtomodel.ActaDto;

import java.util.List;

public interface ActaService {

    List<ActaDto> getActasByLibroId(Long id);
}
