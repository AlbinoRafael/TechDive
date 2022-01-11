package entidades;

public abstract class Personagem {

    private int pontosSaude;
    private int pontosAtaque;
    private int pontosDefesa;

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
}
