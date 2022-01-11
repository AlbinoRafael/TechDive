package entidades;

public class Jogador extends Personagem implements Atacante{

    public final int saudeMaxima = 200;
    private String nome;
    private char sexo;
    private EnumMotivacao motivacao;
    private EnumArma arma;

    public Jogador(int pontosSaude, int pontosAtaque, int pontosDefesa, String nome, char sexo, EnumMotivacao motivacao, EnumArma arma) {
        super(pontosSaude, pontosAtaque, pontosDefesa);
        if(nome!=null&&!nome.isBlank()){this.nome = nome;}else{System.out.println("O nome não pode ser nulo ou vazio!");}
        if(sexo=='M'||sexo=='F') {this.sexo = sexo;}else{System.out.println("Opção inválida!");}
        this.motivacao = motivacao;
        this.arma = arma;
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
