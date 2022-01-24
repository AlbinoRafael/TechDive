package hotel;

public enum EnumTipoQuarto {
    SIMPLES("Simples"),LUXO("de Luxo"),SUPREMA("Suíte suprema");

    private String tipo;

    EnumTipoQuarto(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo(){return this.tipo;}
}
