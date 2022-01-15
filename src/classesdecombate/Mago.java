package classesdecombate;

import entidades.EnumArma;
import entidades.EnumMotivacao;
import entidades.Jogador;
import entidades.Personagem;

public class Mago extends Jogador {
    public Mago(String nome, String sexo,EnumArma arma) {
        super(19, 11, nome, sexo);
        this.setArma(arma);
    }

    @Override
    public void atacar(Personagem personagem) {

    }
}
