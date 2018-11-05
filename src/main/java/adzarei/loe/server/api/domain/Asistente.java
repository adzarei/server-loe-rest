package adzarei.loe.server.api.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Asistente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private TipoAgente tipoAgente;

    private String cargo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acta_id")
    private Acta acta;

}
