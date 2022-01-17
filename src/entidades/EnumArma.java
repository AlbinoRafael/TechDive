package entidades;

public enum EnumArma{

    ESPADA("Espada",5,null),
    MACHADO("Machado",5,null),
    MARTELO("Martelo",5,null),
    CLAVA("Clava",5,null),
    ARCO("Arco",5,"Flecha"),
    BESTA("Besta",5,"Virote"),
    CAJADO("Cajado",5,null),
    LIVRO_MAGIAS("Livro de magias",5,null),
    ARMADILHA("Armadilha",2,null),
    MACHADO_DUPLO("Machado duplo",7,null)
    ;

    private final String value;
    private final int valorAtaque;
    private final String municao;


    EnumArma(String arma, int valorAtaque, String municao) {
        this.value = arma;
        this.valorAtaque = valorAtaque;
        this.municao = municao;
    }
    public String getValue() {
        return value;
    }

    public String getMunicao() {
        return municao;
    }
    public int getValorAtaque(){return valorAtaque;}
}
