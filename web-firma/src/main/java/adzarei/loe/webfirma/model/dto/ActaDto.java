package adzarei.loe.webfirma.model.dto;

import adzarei.loe.webfirma.model.server.Asistente;
import adzarei.loe.webfirma.model.server.Orden;
import adzarei.loe.webfirma.model.server.tipos.TipoActa;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ActaDto {

    private Long id;

    private int numHoja;
    private LocalDateTime fActa;
    private String numlibro;
    private TipoActa tipoActa;
    private String descTipoActa;
    private Long libroId;
    private List<OrdenDto> ordenes = new ArrayList<>();


}
