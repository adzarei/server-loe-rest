package adzarei.loe.server.api.dtomodel;

import lombok.Data;

@Data
public class OrdenDto {

    private Long id;
    private int numOrden;
    private String tituloOrden;
    private String contenido;
    private Long actaId;
}
