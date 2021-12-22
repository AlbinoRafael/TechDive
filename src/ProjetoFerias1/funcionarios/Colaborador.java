package funcionarios;

public class Colaborador extends Funcionario{

    private double beneficios;

    public Colaborador(String nome, String cpf, int idade, double salario, double beneficios) {
        super(nome, cpf, idade, salario); this.beneficios = beneficios;
    }
    public double getBeneficios(){
        return this.beneficios;
    }
}
