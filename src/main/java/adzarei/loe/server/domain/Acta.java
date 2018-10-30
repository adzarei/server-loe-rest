package adzarei.loe.server.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
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
    private List<Firma> firmas; //TODO: decide on mapping of FirmaLibro

    @OneToMany(mappedBy = "acta",orphanRemoval = true)
    private List<Orden> ordenes;

    @OneToMany(mappedBy = "acta",orphanRemoval = true)
    private List<Asistente> asistentes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libro_id")
    private Libro libro;

}
