package entidades;

import classesdecombate.Arqueiro;
import classesdecombate.Guerreiro;
import classesdecombate.Mago;
import classesdecombate.Paladino;

public abstract class Jogador extends Personagem implements Atacante {

    public final int SAUDE_MAXIMA = 200;
    private String nome;
    private String sexo;
    private EnumMotivacao motivacao;
    private EnumArma arma;

    /*public Jogador(int pontosSaude, int pontosAtaque, int pontosDefesa, String nome, String sexo, EnumMotivacao motivacao, EnumArma arma) {
        super(pontosSaude, pontosAtaque, pontosDefesa);
        try {

            if (nome != null && !nome.isBlank()) {
                this.nome = nome;
            } else {
                throw new IllegalArgumentException("O nome não pode ser nulo ou vazio!");
            }
            if (sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("F")){
                this.sexo = sexo;
            } else {
                throw new IllegalArgumentException("Opção inválida! use apenas M ou F");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível criar o jogador!");
        }
    }*/

    public Jogador(int pontosAtaque, int pontosDefesa, String nome, String sexo) {
        super();
        this.pontosAtaque = pontosAtaque;
        this.pontosDefesa = pontosDefesa;
        this.nome = nome;
        this.sexo = sexo;
        this.pontosSaude = SAUDE_MAXIMA;
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
}
