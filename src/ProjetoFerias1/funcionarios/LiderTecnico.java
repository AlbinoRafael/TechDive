package funcionarios;

public class LiderTecnico extends Colaborador implements Gerenciamento{

    public LiderTecnico(String nome, String cpf, int idade, double salario, EnumDepartamento departamento, double beneficios) {
        super(nome, cpf, idade, salario, departamento, beneficios);
    }

    @Override
    public void comandar(String comando){
        System.out.println(comando);
    }

    @Override
    public String toString(){
        String retorno = "\nNome: "+this.getNome()+
                "\nCPF: "+this.getCpf()+
                "\nIdade: "+this.getIdade()+
                "\nSalário: R$ "+this.getSalario()+
                "\nDepartamento: "+this.getDepartamento()+
                "\nBenefícios: R$ "+this.getBeneficios();
        return retorno;
    }
}
