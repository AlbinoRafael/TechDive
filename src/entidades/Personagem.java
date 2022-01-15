package entidades;

public abstract class Personagem {

    protected int pontosSaude;
    protected int pontosAtaque;
    protected int pontosDefesa;

    public Personagem(){}

    public Personagem(int pontosSaude, int pontosAtaque, int pontosDefesa) {
        this.pontosSaude = pontosSaude;
        this.pontosAtaque = pontosAtaque;
        this.pontosDefesa = pontosDefesa;
    }

    public int getPontosSaude() {
        return pontosSaude;
    }

    public int getPontosAtaque() {
        return pontosAtaque;
    }

    public int getPontosDefesa() {
        return pontosDefesa;
    }

    public void setPontosSaude(int pontosSaude) {
        this.pontosSaude = pontosSaude;
    }
}
