package classesinimigas;

import entidades.EnumArma;
import entidades.Inimigo;

public class Lider extends Inimigo {
    public Lider() {
        super(200, 15, 15, EnumArma.MACHADO_DUPLO);
    }
}
