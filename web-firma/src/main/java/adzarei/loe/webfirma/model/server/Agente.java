package adzarei.loe.webfirma.model.server;


import adzarei.loe.webfirma.model.server.tipos.TipoAgente;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Agente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoAgente tipoAgente;

    private String nombre;
    private String idFiscal;
    private String titulo;
    private LocalDateTime fInicio;
    private LocalDateTime fFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libro_id")
    private Libro libro;
}
