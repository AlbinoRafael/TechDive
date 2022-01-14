package classesdecombate;

import entidades.EnumArma;
import entidades.EnumMotivacao;
import entidades.Jogador;
import entidades.Personagem;

public class Paladino extends Jogador {
    public Paladino(int pontosSaude, int pontosAtaque, int pontosDefesa, String nome, char sexo, EnumMotivacao motivacao, EnumArma arma) {
        super(pontosSaude, pontosAtaque, pontosDefesa,nome, sexo, motivacao, arma);
    }

    @Override
    public void atacar(Personagem personagem) {
        personagem.setPontosSaude(personagem.getPontosSaude()-(this.getPontosAtaque()- personagem.getPontosDefesa()));
    }
}
