package funcionarios;

public class Colaborador extends Funcionario{

    private double beneficios;

    public Colaborador(String nome, String cpf, int idade, double salario, EnumDepartamento departamento, double beneficios) {
        super(nome, cpf, idade, salario, departamento);
        this.beneficios = beneficios;
    }

    public double getBeneficios(){
        return this.beneficios;
    }

    public void setBeneficios(double beneficios) {
        this.beneficios = beneficios;
    }

    @Override
    public String toString(){
        String retorno = "\nNome: "+this.getNome()+
                        "\nCPF: "+this.getCpf()+
                        "\nIdade: "+this.getIdade()+
                        "\nSalário: R$ "+this.getSalario()+
                        "\nDepartamento: "+this.getDepartamento().getDisplayName()+
                        "\nBenefícios: R$ "+this.getBeneficios()+
                        "\nSituação: "+this.estaAtivo(this.estaAtivo());
        return retorno;
    }
}
