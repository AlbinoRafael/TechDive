package batalhafinal;

import classesdecombate.Arqueiro;
import classesdecombate.Guerreiro;
import classesinimigas.Armeiro;
import entidades.EnumArma;
import entidades.EnumMotivacao;
import entidades.Inimigo;
import entidades.Jogador;

public class Teste {

    public static void main(String[] args) {

        Jogador jogador = new Guerreiro("DAKAR","M",EnumArma.LIVRO_MAGIAS);
        Inimigo inimigo = new Armeiro(19,13,EnumArma.ESPADA);

        jogador.setMotivacao(EnumMotivacao.VINGANCA);

    }
}
