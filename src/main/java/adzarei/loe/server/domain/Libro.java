package adzarei.loe.server.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany
    private List<Agente> agentes;

    @OneToMany
    private List<Acta> actas;

    @OneToMany
    private List<Firma> firmas;

}
