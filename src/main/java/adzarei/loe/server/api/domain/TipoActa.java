package adzarei.loe.server.api.domain;

public enum TipoActa {
    INSPECION_PREVIA("A-00"),
    INICIO("A-01"),
    FIN("A-02"),
    OBRA("A-03"),
    OTRO("A-99");

    TipoActa(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    private String codigo;

}
