package adzarei.loe.server.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
public class ActiveToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    @Column(columnDefinition = "varchar(36)")
    String uuid;

    @ManyToOne
    LoginUser user;
}
