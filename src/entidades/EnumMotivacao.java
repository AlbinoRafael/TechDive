package entidades;

public enum EnumMotivacao implements StringValueEnum{
    MOTIVACAO1("MOTIVACAO1","Vingança"),
    MOTIVACAO2("MOTIVACAO2","Glória");

    private final String value;
    private final String displayName;

    EnumMotivacao(String motivacao, String tipo) {
        this.value = motivacao;
        this.displayName = tipo;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
