package classesinimigas;

import entidades.EnumArma;
import entidades.Inimigo;
import entidades.Personagem;

public class Armeiro extends Inimigo {
    public Armeiro(int pontosAtaque, int pontosDefesa, EnumArma arma) {
        super(100, pontosAtaque, pontosDefesa, arma);
    }

    @Override
    public void atacar(Personagem personagem) {
        personagem.setPontosSaude(personagem.getPontosSaude()-(this.getPontosAtaque()-personagem.getPontosDefesa()));
    }
}
