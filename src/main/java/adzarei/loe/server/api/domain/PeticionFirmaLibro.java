package adzarei.loe.server.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PeticionFirmaLibro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;
}
