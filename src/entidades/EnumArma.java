package entidades;

public enum EnumArma implements StringValueEnum{

    ESPADA("Espada","jogador",5),
    MACHADO("Machado","jogador",5),
    MARTELO("Martelo","jogador",5),
    CLAVA("Clava","jogador",5),
    ARCO("Arco","jogador",5),
    BESTA("Besta","jogador",5),
    CAJADO("Cajado","jogador",5),
    LIVRO_MAGIAS("Livro de magias","jogador",5),
    ARMADILHA("Armadilha","armadilha",2),
    MACHADO_DUPLO("Machado duplo","lider",7)
    ;

    private final String value;
    private final String displayName;
    private final int valorAtaque;

    EnumArma(String arma, String tipoArma, int valorAtaque) {
        this.value = arma;
        this.displayName = tipoArma;
        this.valorAtaque = valorAtaque;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    public int getValorAtaque(){return valorAtaque;}
}
