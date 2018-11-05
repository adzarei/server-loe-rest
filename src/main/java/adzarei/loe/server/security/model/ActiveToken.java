package adzarei.loe.server.security.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ActiveToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    @Column(columnDefinition = "varchar(36)")
    String token;

    @ManyToOne
    LoginUser user;
}
