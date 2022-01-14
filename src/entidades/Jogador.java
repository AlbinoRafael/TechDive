package entidades;

import classesdecombate.Arqueiro;
import classesdecombate.Guerreiro;
import classesdecombate.Mago;
import classesdecombate.Paladino;

public abstract class Jogador extends Personagem implements Atacante {

    public final int saudeMaxima = 200;
    private String nome;
    private char sexo;
    private EnumMotivacao motivacao;
    private EnumArma arma;

    public Jogador(int pontosSaude, int pontosAtaque, int pontosDefesa, String nome, char sexo, EnumMotivacao motivacao, EnumArma arma) {
        super(pontosSaude, pontosAtaque, pontosDefesa);
        this.pontosSaude = pontosSaude;
        try {

            if (nome != null && !nome.isBlank()) {
                this.nome = nome;
            } else {
                throw new IllegalArgumentException("O nome não pode ser nulo ou vazio!");
            }
            if (sexo == 'M' || sexo == 'F') {
                this.sexo = sexo;
            } else {
                throw new IllegalArgumentException("Opção inválida! use apenas M ou F");
            }
            if (motivacao.equals(EnumMotivacao.VINGANCA) || motivacao.equals(EnumMotivacao.GLORIA)) {
                this.motivacao = motivacao;
            } else {
                throw new IllegalArgumentException("Opção inválida!");
            }
            if(this instanceof Arqueiro && arma.equals(EnumArma.ARCO)|| arma.equals(EnumArma.BESTA)){
                this.pontosAtaque = 18;
                this.pontosDefesa = 13;
                this.arma = arma;
            }else if(this instanceof Guerreiro && arma.equals(EnumArma.ESPADA)|| arma.equals(EnumArma.MACHADO)){
                this.pontosAtaque = 15;
                this.pontosDefesa = 15;
                this.arma = arma;
            }else if(this instanceof Mago && arma.equals(EnumArma.CAJADO)|| arma.equals(EnumArma.LIVRO_MAGIAS)){
                this.pontosAtaque = 19;
                this.pontosDefesa = 11;
                this.arma = arma;
            }else if(this instanceof Paladino && arma.equals(EnumArma.MARTELO)|| arma.equals(EnumArma.CLAVA)){
                this.pontosAtaque = 13;
                this.pontosDefesa = 18;
                this.arma = arma;
            }
        } catch (Exception e) {
            System.out.println("Não foi possível criar o jogador!");
        }
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public EnumMotivacao getMotivacao() {
        return motivacao;
    }

    public EnumArma getArma() {
        return arma;
    }
}
