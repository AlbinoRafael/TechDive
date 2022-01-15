package classesdecombate;

import entidades.EnumArma;
import entidades.EnumMotivacao;
import entidades.Jogador;
import entidades.Personagem;

public class Arqueiro extends Jogador {
    public Arqueiro(String nome, String sexo, EnumArma arma) {
        super(18, 13, nome, sexo);
        this.setArma(arma);
    }

    @Override
    public void atacar(Personagem personagem) {

    }
}
