package adzarei.loe.webfirma.model.dto;

import adzarei.loe.webfirma.model.server.tipos.TipoAgente;
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
    private Long libroId;

}
