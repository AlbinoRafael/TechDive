package classesdecombate;

import entidades.EnumArma;
import entidades.Jogador;

public class Paladino extends Jogador {
    public Paladino(String nome, String sexo, EnumArma arma) {
        super(13, 18, nome, sexo);
        this.setArma(arma);
    }
}
