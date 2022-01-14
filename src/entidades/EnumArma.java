package entidades;

public enum EnumArma implements StringValueEnum{

    ESPADA("Espada","jogador"),
    MACHADO("Machado","jogador"),
    MARTELO("Martelo","jogador"),
    CLAVA("Clava","jogador"),
    ARCO("Arco","jogador"),
    BESTA("Besta","jogador"),
    CAJADO("Cajado","jogador"),
    LIVRO_MAGIAS("Livro de magias","jogador"),
    ARMADILHA("Armadilha","armadilha"),
    MACHADO_DUPLO("Machado duplo","lider")
    ;

    private final String value;
    private final String displayName;

    EnumArma(String arma, String tipoArma) {
        this.value = arma;
        this.displayName = tipoArma;
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
