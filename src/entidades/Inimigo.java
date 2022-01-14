package entidades;

public abstract class Inimigo extends Personagem implements Atacante{

    private EnumArma arma;

    public Inimigo(int pontosSaude, int pontosAtaque, int pontosDefesa, EnumArma arma) {
        super(pontosSaude, pontosAtaque, pontosDefesa);
        this.arma = arma;
    }

    public EnumArma getArma() {
        return arma;
    }
}
