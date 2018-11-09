package adzarei.loe.server.api.dtomodel;

import adzarei.loe.server.api.domain.tipos.TipoAgente;
import lombok.Data;


import java.time.LocalDateTime;

@Data
public class AgenteDto {

    private TipoAgente tipoAgente;
    private String nombre;
    private String idFiscal;
    private String titulo;
    private LocalDateTime fInicio;
    private LocalDateTime fFin;

}
