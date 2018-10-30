package adzarei.loe.server.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Adjunto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Nombre;
    private String mediaType;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String contenido;
}
