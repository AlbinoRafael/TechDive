package entidades;

import classesdecombate.Arqueiro;
import classesdecombate.Guerreiro;
import classesdecombate.Mago;
import classesdecombate.Paladino;
import dados.Dado;

import java.util.InputMismatchException;

public abstract class Jogador extends Personagem implements Atacante {

    public final int SAUDE_MAXIMA = 200;
    private String nome;
    private String sexo;
    private EnumMotivacao motivacao;
    private EnumArma arma;

    public Jogador(int pontosAtaque, int pontosDefesa, String nome, String sexo) {
        super();
        this.pontosAtaque = pontosAtaque;
        this.pontosDefesa = pontosDefesa;
        this.pontosSaude = SAUDE_MAXIMA;

        if (!nome.isBlank() || !nome.isEmpty()) {
            this.nome = nome;
        }else{
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio!");
        }
        if (!sexo.isBlank() || !sexo.isEmpty()) {
            this.sexo = sexo;
        }else{
            throw new IllegalArgumentException("Sexo não pode ser nulo ou vazio!");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public EnumMotivacao getMotivacao() {
        return motivacao;
    }

    public void setMotivacao(EnumMotivacao motivacao) {
        this.motivacao = motivacao;
    }

    public EnumArma getArma() {
        return arma;
    }

    public void setArma(EnumArma arma) {

        if (this instanceof Guerreiro && (arma.equals(EnumArma.ESPADA) || arma.equals(EnumArma.MACHADO))) {
            this.arma = arma;
        } else if (this instanceof Arqueiro && (arma.equals(EnumArma.ARCO) || arma.equals(EnumArma.BESTA))) {
            this.arma = arma;
        } else if (this instanceof Mago && (arma.equals(EnumArma.CAJADO) || arma.equals(EnumArma.LIVRO_MAGIAS))) {
            this.arma = arma;
        } else if (this instanceof Paladino && (arma.equals(EnumArma.MARTELO) || arma.equals(EnumArma.CLAVA))) {
            this.arma = arma;
        } else {
            throw new IllegalArgumentException("Erro, arma não suportada pela classe!");
        }
    }

    @Override
    public void atacar(Personagem personagem) {
        int valorDado = Dado.jogarDado(1, 20);
        int ataqueTotal = this.getPontosAtaque() + getArma().getValorAtaque() + valorDado;
        if (valorDado == 1) {
            System.out.println("Você realizou um ataque crítico! Você errou seu ataque! O inimigo não sofreu dano algum.\n");
        } else if (valorDado == 20) {
            if (ataqueTotal > personagem.getPontosDefesa()) {
                if (this instanceof Guerreiro || this instanceof Paladino) {
                    System.out.printf("Você realizou um ataque crítico! Você atacou com seu/sua %s e causou %d de dano no inimigo!\n", getArma().getValue(), ataqueTotal);
                } else if (this instanceof Arqueiro) {
                    System.out.printf("Você realizou um ataque crítico! Você atacou com seu/sua %s, a/o %s o atingiu, causando %d de dano no inimigo!\n", getArma().getValue(), getArma().getMunicao(), ataqueTotal);
                } else if (this instanceof Mago) {
                    if (this.getArma() == EnumArma.CAJADO) {
                        System.out.printf("Você realizou um ataque crítico! Você atacou com seu cajado, lançando uma bola de fogo e causou %d de dano no inimigo!\n", ataqueTotal);
                    } else if (this.getArma() == EnumArma.LIVRO_MAGIAS) {
                        System.out.printf("Você realizou um ataque crítico! Você atacou absorvendo energia do livro com uma mão e liberando com a outra e causou %d de dano no inimigo!\n", ataqueTotal);
                    }
                }
                personagem.setPontosSaude(personagem.getPontosSaude() - ataqueTotal);
                if (personagem.getPontosSaude() < 0) {
                    System.out.println("você reduziu os pontos de vida do inimigo a zero!\n");
                } else {
                    System.out.printf("e agora possui %d pontos de vida!\n", personagem.getPontosSaude());
                }
            } else {
                System.out.println("Você realizou um ataque crítico! Você errou seu ataque! O inimigo não sofreu dano algum.\n");
            }
        } else {
            if (ataqueTotal > personagem.getPontosDefesa()) {
                if (this instanceof Guerreiro || this instanceof Paladino) {
                    System.out.printf("\nVocê atacou com seu/sua %s e causou %d de dano no inimigo!\n", getArma().getValue(), ataqueTotal - personagem.getPontosDefesa());
                } else if (this instanceof Arqueiro) {
                    System.out.printf("\nVocê atacou com seu/sua %s, a/o %s o atingiu, causando %d de dano no inimigo!\n", getArma().getValue(), getArma().getMunicao(), ataqueTotal - personagem.getPontosDefesa());
                } else if (this instanceof Mago) {
                    if (this.getArma() == EnumArma.CAJADO) {
                        System.out.printf("\nVocê atacou com seu cajado, lançando uma bola de fogo e causou %d de dano no inimigo!\n", ataqueTotal - personagem.getPontosDefesa());
                    } else if (this.getArma() == EnumArma.LIVRO_MAGIAS) {
                        System.out.printf("\nVocê atacou absorvendo energia do livro com uma mão e liberando com a outra e causou %d de dano no inimigo!\n", ataqueTotal - personagem.getPontosDefesa());
                    }
                }
                personagem.setPontosSaude(personagem.getPontosSaude() - (ataqueTotal - personagem.getPontosDefesa()));
                if (personagem.getPontosSaude() < 0) {
                    System.out.println("você reduziu os pontos de vida do inimigo a zero!\n");
                } else {
                    System.out.printf("e agora possui %d pontos de vida!\n", personagem.getPontosSaude());
                }
            } else {
                System.out.println("Você realizou um ataque crítico! Você errou seu ataque! O inimigo não sofreu dano algum.\n");
            }
        }
    }
}
