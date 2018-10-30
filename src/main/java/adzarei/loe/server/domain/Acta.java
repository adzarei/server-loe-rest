package adzarei.loe.server.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Acta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numHoja;
    private LocalDateTime fActa;

    private String numlibro;

    @Enumerated(EnumType.STRING)
    private TipoActa tipoActa;
    private String descTipoActa;

    @OneToMany
    private List<Firma> firmas = new ArrayList<>(); //TODO: decide on mapping of FirmaLibro

    @OneToMany(mappedBy = "acta",orphanRemoval = true)
    private List<Orden> ordenes = new ArrayList<>();

    @OneToMany(mappedBy = "acta",orphanRemoval = true)
    private List<Asistente> asistentes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libro_id")
    private Libro libro;

    public Orden addOrden (Orden orden){
        orden.setActa(this);
        this.ordenes.add(orden);
        return orden;
    }

    public Asistente addAsistente (Asistente asistente){
        asistente.setActa(this);
        this.asistentes.add(asistente);
        return asistente;
    }

    public Firma addFirma(Firma firma){
        this.firmas.add(firma);
        return firma;
    }
}
