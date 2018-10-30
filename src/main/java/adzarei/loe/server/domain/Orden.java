package adzarei.loe.server.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Orden{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    private int numOrden;

    @Lob
    @Column(columnDefinition = "TINYTEXT")
    private String tituloOrden; //TODO: Queremos que sea TINYTEXT. Necesitamos @Lob?

    @Lob
    @Column(columnDefinition = "TEXT") //21,844 caracteres ut-8 como maximo.
    private String contenido;

    @OneToMany(orphanRemoval = true,mappedBy = "orden")
    private List<Adjunto> adjuntos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "acta_id")
    private Acta acta;
}
