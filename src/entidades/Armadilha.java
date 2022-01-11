package entidades;

public class Armadilha implements Atacante{

    private int pontosAtaque;
    private EnumArma arma;

    public Armadilha(){
        this.pontosAtaque = 5;
        this.arma = EnumArma.ARMADILHA;
    }

    public int getPontosAtaque() {
        return pontosAtaque;
    }

    public void setPontosAtaque(int pontosAtaque) {
        this.pontosAtaque = pontosAtaque;
    }

    public EnumArma getArma() {
        return arma;
    }

    public void setArma(EnumArma arma) {
        this.arma = arma;
    }
}
