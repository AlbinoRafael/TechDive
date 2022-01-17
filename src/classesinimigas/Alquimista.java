package classesinimigas;

import entidades.EnumArma;
import entidades.Inimigo;

public class Alquimista extends Inimigo {
    public Alquimista() {
        super(100, 15, 10, EnumArma.CAJADO);
    }
}
