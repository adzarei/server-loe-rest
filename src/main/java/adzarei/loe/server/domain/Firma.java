package adzarei.loe.server.domain;

import lombok.Data;
import org.jvnet.hk2.config.GeneratedServiceName;

import javax.persistence.*;

@Data
@Entity
public class Firma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoAgente tipoAgente;
    private String descipcionAgente;
    private String sello;
    private String certificado;
    private String email;
}
