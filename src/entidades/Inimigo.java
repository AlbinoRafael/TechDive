package entidades;

import classesinimigas.Alquimista;
import classesinimigas.Armeiro;
import classesinimigas.Lider;
import dados.Dado;

public abstract class Inimigo extends Personagem implements Atacante {

    private EnumArma arma;

    public Inimigo(int pontosSaude, int pontosAtaque, int pontosDefesa, EnumArma arma) {
        super(pontosSaude, pontosAtaque, pontosDefesa);
        this.arma = arma;
    }

    public EnumArma getArma() {
        return arma;
    }

    @Override
    public void atacar(Personagem personagem) {
        int valorDado = Dado.jogarDado(1, 20);
        int ataqueTotal = this.getPontosAtaque() + getArma().getValorAtaque() + valorDado;
        if (valorDado == 1) {
            System.out.println("\nO inimigo errou o ataque! Você não sofreu dano.\n");
        } else if (valorDado == 20) {
            if (personagem.getPontosDefesa() < ataqueTotal) {
                personagem.setPontosSaude(personagem.getPontosSaude() - ataqueTotal);
                System.out.printf("\nO inimigo acertou um ataque crítico! Você sofreu %d de dano e agora possui %dpontos de vida.\n", ataqueTotal, personagem.getPontosSaude());
            } else {
                System.out.println("\nO inimigo errou o ataque! Você não sofreu dano.\n");
            }
        } else {
            if (personagem.getPontosDefesa() < ataqueTotal) {
                personagem.setPontosSaude(personagem.getPontosSaude() - (ataqueTotal - personagem.getPontosDefesa()));
                System.out.printf("\nO inimigo atacou! Você sofreu %d de dano e agora possui %d pontos de vida.\n", ataqueTotal - personagem.getPontosDefesa(), personagem.getPontosSaude());
            } else {
                System.out.println("\nO inimigo errou o ataque! Você não sofreu dano.\n");
            }
        }
    }

}
