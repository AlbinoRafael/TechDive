package entidades;

public enum EnumMotivacao{
    VINGANCA("Vingança"),
    GLORIA("Glória");

    private final String value;


    EnumMotivacao(String motivacao) {
        this.value = motivacao;
    }
    public String getValue() {
        return value;
    }

}
