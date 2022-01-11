package entidades;

public enum EnumArma implements StringValueEnum{

    ARMAJOGADOR1("ARMAJOGADOR1","Espada"),
    ARMAJOGADOR2("ARMAJOGADOR2","Machado"),
    ARMAJOGADOR3("ARMAJOGADOR3","Martelo"),
    ARMAJOGADOR4("ARMAJOGADOR4","Clava"),
    ARMAJOGADOR5("ARMAJOGADOR5","Arco"),
    ARMAJOGADOR6("ARMAJOGADOR6","Besta"),
    ARMAJOGADOR7("ARMAJOGADOR7","Cajado"),
    ARMAJOGADOR8("ARMA8JOGADOR","Livro de Magias"),
    ARMADILHA("ARMADILHA","Armadilha"),
    ARMALIDER("ARMALIDER","Machado duplo")
    ;

    private final String value;
    private final String displayName;

    EnumArma(String arma, String tipo) {
        this.value = arma;
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
