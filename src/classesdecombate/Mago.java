package classesdecombate;

import entidades.EnumArma;
import entidades.Jogador;

public class Mago extends Jogador {
    public Mago(String nome, String sexo, EnumArma arma) {
        super(19, 11, nome, sexo);
        this.setArma(arma);
    }
}
