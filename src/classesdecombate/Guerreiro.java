package classesdecombate;

import entidades.EnumArma;
import entidades.Jogador;
import entidades.Personagem;

public class Guerreiro extends Jogador {
    public Guerreiro(String nome, String sexo, EnumArma arma) {
        super(15, 15, nome, sexo);
        this.setArma(arma);
    }

    @Override
    public void atacar(Personagem personagem) {

    }
}
