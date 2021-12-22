package funcionarios;

public abstract class Funcionario {

    private String nome;
    private String cpf;
    private int idade;
    private double salario;
    private boolean estaAtivo;

    public Funcionario(){}

    public Funcionario(String nome, String cpf, int idade, double salario){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.salario = salario;
        this.estaAtivo = true;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public double getSalario() {
        return salario;
    }
    public boolean estaAtivo(){
        return estaAtivo;
    }


    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                ", salario=" + salario +
                ", esta ativo=" +estaAtivo+
                '}';
    }
}
