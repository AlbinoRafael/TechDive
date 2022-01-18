package banco.contas;

public abstract class Conta {

    public static int id = 1;
    private int idConta;
    private String nomeTitular;
    private String cpf;

    private Conta(){}

    public Conta(String nomeTitular, String cpf) {
        this.idConta = id;
        this.nomeTitular = nomeTitular;
        this.cpf = cpf;
        id++;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
