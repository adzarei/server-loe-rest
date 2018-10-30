package adzarei.loe.server.domain;

import lombok.Data;
import org.jvnet.hk2.config.GeneratedServiceName;

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

    private String numlibro; //TODO: add Libro FK

    @Enumerated(EnumType.STRING)
    private TipoActa tipoActa;
    private String descTipoActa;

    @OneToMany
    private List<Firma> firmas;

    @OneToMany
    private List<Orden> ordenes;

    @OneToMany
    private List<Asistente> asistentes;

}
