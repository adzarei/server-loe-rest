package adzarei.loe.server.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Orden{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition = "TINYTEXT")
    private int numOrden;
    private String tituloOrden; //TODO: Queremos que sea TINYTEXT. Necesitamos @Lob?

    @Lob
    @Column(columnDefinition = "TEXT") //21,844 caracteres ut-8 como maximo.
    private String contenido;

    @OneToMany(orphanRemoval = true,mappedBy = "orden")
    private List<Adjunto> adjuntos;

    @ManyToOne
    @JoinColumn(name = "acta_id")
    private Acta acta;
}
