package adzarei.loe.webfirma.model.server;

import adzarei.loe.webfirma.model.server.tipos.TipoAgente;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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
