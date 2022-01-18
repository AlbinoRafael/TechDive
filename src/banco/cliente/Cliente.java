package banco.cliente;

public class Cliente {

    private String nomeDoTitular;
    private String cpf;

    private Cliente(){}

    public Cliente(String nomeDoTitular, String cpf) {
        this.nomeDoTitular = nomeDoTitular;
        this.cpf = cpf;
    }

    public String getNomeDoTitular() {
        return nomeDoTitular;
    }

    public void setNomeDoTitular(String nomeDoTitular) {
        this.nomeDoTitular = nomeDoTitular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
