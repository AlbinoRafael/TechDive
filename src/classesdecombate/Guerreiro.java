package classesdecombate;

import entidades.EnumArma;
import entidades.Jogador;

public class Guerreiro extends Jogador {
    public Guerreiro(String nome, String sexo, EnumArma arma) {
        super(15, 15, nome, sexo);
        this.setArma(arma);
    }
}
