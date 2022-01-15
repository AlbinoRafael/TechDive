package entidades;

import classesinimigas.Alquimista;
import classesinimigas.Armeiro;
import classesinimigas.Lider;

public abstract class Inimigo extends Personagem implements Atacante {

    private EnumArma arma;

    public Inimigo(int pontosSaude, int pontosAtaque, int pontosDefesa, EnumArma arma){
        super(pontosSaude, pontosAtaque, pontosDefesa);
        try {
            if (this instanceof Armeiro && arma.equals(EnumArma.ESPADA)) {
                this.arma = arma;
            }else
            if (this instanceof Alquimista && arma.equals(EnumArma.CAJADO)) {
                this.arma = arma;
            } else if (this instanceof Lider && arma.equals(EnumArma.MACHADO_DUPLO)) {
                this.arma = arma;
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Não foi possivel criar o inimigo");
        }
    }

    public EnumArma getArma() {
        return arma;
    }
}
