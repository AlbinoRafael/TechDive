package hotel;

public enum EnumTipoQuarto {
    SIMPLES("Simples"),LUXO("de Luxo");

    private String tipo;

    EnumTipoQuarto(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo(){return this.tipo;}
}
