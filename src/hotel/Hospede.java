package hotel;

import java.util.Objects;

public class Hospede implements Comparable<Hospede>{

    private String nome;
    private String sobrenome;
    private String documentoIdentificacao;
    private String dataNascimento;
    private EnumTipoQuarto tipoQuarto;


    public Hospede(String nome, String sobrenome, String documentoIdentificacao, String dataNascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documentoIdentificacao = documentoIdentificacao;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDocumentoIdentificacao() {
        return documentoIdentificacao;
    }

    public void setDocumentoIdentificacao(String documentoIdentificacao) {
        this.documentoIdentificacao = documentoIdentificacao;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospede hospede = (Hospede) o;
        return nome.equals(hospede.nome) && documentoIdentificacao.equals(hospede.documentoIdentificacao) && dataNascimento.equals(hospede.dataNascimento);
    }

    @Override
    public String toString() {
        return "nome: " + nome +'\n' +
                "documentoIdentificacao: " + documentoIdentificacao + '\n' +
                "data de nascimento: " + dataNascimento + '\n';
    }

    @Override
    public int compareTo(Hospede o) {
        return this.getNome().compareTo(o.getNome());
    }
}
