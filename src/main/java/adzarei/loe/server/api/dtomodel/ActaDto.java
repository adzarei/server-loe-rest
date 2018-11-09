package adzarei.loe.server.api.dtomodel;

import adzarei.loe.server.api.domain.tipos.TipoActa;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ActaDto {

    private int numHoja;
    private LocalDateTime fActa;
    private String numlibro;
    private TipoActa tipoActa;
    private String descTipoActa;

}
