package batalhafinal;

import classesdecombate.Arqueiro;
import classesdecombate.Guerreiro;
import entidades.EnumArma;
import entidades.EnumMotivacao;

public class Teste {

    public static void main(String[] args) {
        Arqueiro arqueiro = new Arqueiro(100, 19,11, "Arqueiro1",'M', EnumMotivacao.VINGANCA, EnumArma.ARCO);
        Guerreiro guerreiro = new Guerreiro(200, 15,15, "Guerreiro1", 'M', EnumMotivacao.VINGANCA, EnumArma.ESPADA);
        System.out.println("Arqueiro ataca o guerreiro!");
        System.out.println("saude do guerreiro "+guerreiro.getPontosSaude());
        arqueiro.atacar(guerreiro);
        System.out.println("saude do guerreiro depois do ataque "+guerreiro.getPontosSaude());
        System.out.println("Guerreiro ataca o arqueiro!");
        System.out.println("Saude do arqueiro "+arqueiro.getPontosSaude());
        guerreiro.atacar(arqueiro);
        System.out.println("saude do arqueiro depois do ataque "+arqueiro.getPontosSaude());

    }
}
