package hotel;

import java.util.Objects;

public class Hospede implements Comparable<Hospede>{

    private String nome;
    private String sobrenome;
    private String documentoIdentificacao;
    private String dataNascimento;

    public Hospede(String nome, String sobrenome, String documentoIdentificacao, String dataNascimento) {
        if(nome!=null && !nome.isBlank()&& !nome.isEmpty()){this.nome = nome;}
        if(sobrenome!=null && !sobrenome.isBlank()&& !sobrenome.isEmpty()){this.sobrenome = sobrenome;}
        if(validaCPF(documentoIdentificacao)||validaRG(documentoIdentificacao)){this.documentoIdentificacao = documentoIdentificacao;}
        if(validaDataNascimento(dataNascimento)){this.dataNascimento = dataNascimento;}
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
        return nome +' '+sobrenome;
    }

    @Override
    public int compareTo(Hospede o) {
        return this.getNome().compareTo(o.getNome());
    }

    public boolean validaCPF(String cpf) {
        boolean isValido = false;
        if (cpf.length() == 11 && cpf.matches("[+-]?\\d*(\\.\\d+)?") && !cpf.contains("^[a-zA-Z]") &&
                !cpf.equals(null) && !cpf.isBlank() && !cpf.contains(" ")) {
            int contador = 1;
            char[] cpfs = cpf.toCharArray();
            for (int i = 0; i < cpfs.length - 1; i++) {
                if (cpfs[i] == cpfs[i + 1]) {
                    contador++;
                }
            }
            if (contador == cpf.length()) {
                isValido = false;
            } else {
                isValido = true;
            }
        }
        return isValido;
    }

    public boolean validaRG(String rg) {
        boolean isValido = false;
        if (rg.length() == 8 && rg.matches("[+-]?\\d*(\\.\\d+)?") && !rg.contains("^[a-zA-Z]") &&
                !rg.equals(null) && !rg.isBlank() && !rg.contains(" ")) {
            int contador = 1;
            char[] rgs = rg.toCharArray();
            for (int i = 0; i < rgs.length - 1; i++) {
                if (rgs[i] == rgs[i + 1]) {
                    contador++;
                }
            }
            if (contador == rg.length()) {
                isValido = false;
            } else {
                isValido = true;
            }
        }
        return isValido;
    }

    public boolean validaDataNascimento(String dataNascimento) {
        boolean isValido = false;
        if (dataNascimento.length() == 10 && !dataNascimento.contains("^[a-zA-Z]") &&
                !dataNascimento.equals(null) && !dataNascimento.isBlank() && !dataNascimento.contains(" ")) {
            int contador = 1;
            char[] rgs = dataNascimento.toCharArray();
            for (int i = 0; i < rgs.length - 1; i++) {
                if (rgs[i] == rgs[i + 1]) {
                    contador++;
                }
            }
            if (contador == dataNascimento.length()) {
                isValido = false;
            } else {
                isValido = true;
            }
        }
        return isValido;
    }

}
