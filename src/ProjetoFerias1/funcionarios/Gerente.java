package funcionarios;

public abstract class Gerente extends Funcionario implements Gerenciamento{

    private double bonus;

    private Gerente(){}

    public Gerente(String nome, String cpf, int idade, double salario, EnumDepartamento departamento, double bonus) {
        super(nome, cpf, idade, salario, departamento);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }
    public void setBonus(double bonus) {
        this.setSalario(this.getSalario()+bonus);
    }

    @Override
    public String toString(){
        String retorno = "\nNome: "+this.getNome()+
                "\nCPF: "+this.getCpf()+
                "\nIdade: "+this.getIdade()+
                "\nSalário: R$ "+this.getSalario()+
                "\nDepartamento: "+this.getDepartamento().getDisplayName()+
                "\nBônus: R$ "+this.getBonus()+
                "\nSituação: "+this.estaAtivo(this.estaAtivo());
        return retorno;
    }
}
