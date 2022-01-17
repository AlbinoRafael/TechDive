package classesinimigas;

import entidades.EnumArma;
import entidades.Inimigo;

public class Armeiro extends Inimigo {
    public Armeiro() {
        super(100, 10, 10, EnumArma.ESPADA);
    }
}
