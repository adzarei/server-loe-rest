package adzarei.loe.server.api.domain.tipos;

public enum TipoAgente {
    DO("C-00"),
    DEO("C-01"),
    CONSTRUCTOR("C-02"),
    CSS("C-03"),
    PROMOTOR("C-04"),
    PROYECTISTA("C-05"),
    OTRO("C-99");

    private String codigo;

    TipoAgente(String codigo) {
        this.codigo = codigo;
    }


    public String getCodigo() {
        return codigo;
    }
}
