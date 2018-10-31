package adzarei.loe.server.api.v1.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LibroDto {

    private Long id;
    private String numlibro;
    private LocalDateTime fAutorizacion;
    private LocalDateTime fInicioObra;
    private LocalDateTime fFinObra;
    private String numExpColegio;
    private String obra;
    private String situacion;
    private String numLicencia;
    private String ayto;
    private LocalDateTime fLicencia;

    private String CAE;
    private LocalDateTime fCAE;

}
