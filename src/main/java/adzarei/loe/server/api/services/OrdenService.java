package adzarei.loe.server.api.services;

import adzarei.loe.server.api.dtomodel.OrdenDto;

import java.util.List;

public interface OrdenService {

    List<OrdenDto> getOrdenesByActaId(Long id);
    void createNewOrden(OrdenDto ordenDto);
}
