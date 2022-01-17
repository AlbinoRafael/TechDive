package entidades;

import dados.Dado;

public class Armadilha implements Atacante{

    private int pontosAtaque;
    private EnumArma arma;

    public Armadilha(){
        this.pontosAtaque = 5;
        this.arma = EnumArma.ARMADILHA;
    }

    public int getPontosAtaque() {
        return pontosAtaque;
    }

    public EnumArma getArma() {
        return arma;
    }

    public void setArma(EnumArma arma) {
        this.arma = arma;
    }

    @Override
    public void atacar(Personagem personagem) {
        int valorDado = Dado.jogarDado(1,10);
        int ataqueTotal = this.getPontosAtaque()+arma.getValorAtaque()+ valorDado;
        if(valorDado==1){
            System.out.println("O ataque da armadilha pegou de raspão e você não sofreu dano.");
        }else {
            if(ataqueTotal > personagem.getPontosDefesa()) {
                personagem.setPontosSaude(personagem.getPontosSaude() - (ataqueTotal - personagem.getPontosDefesa()));
                System.out.println("Você caiu em uma armadilha!");
                System.out.printf("Você sofreu %d de dano e agora possui %d pontos de vida.\n", ataqueTotal, personagem.getPontosSaude());
            }else{
                System.out.println("O ataque da armadilha pegou de raspão e você não sofreu dano.");
            }
        }
    }
}
