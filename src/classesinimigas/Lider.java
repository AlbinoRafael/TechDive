package classesinimigas;

import entidades.EnumArma;
import entidades.Inimigo;
import entidades.Personagem;

public class Lider extends Inimigo {
    public Lider(int pontosSaude, int pontosAtaque, int pontosDefesa, EnumArma arma) throws Exception {
        super(pontosSaude, pontosAtaque, pontosDefesa, arma);
    }

    @Override
    public void atacar(Personagem personagem) {
        personagem.setPontosSaude(personagem.getPontosSaude()-(this.getPontosAtaque()-personagem.getPontosDefesa()));
    }
}
