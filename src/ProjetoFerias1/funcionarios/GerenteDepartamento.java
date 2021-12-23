package funcionarios;

public class GerenteDepartamento extends Gerente{

    public GerenteDepartamento(String nome, String cpf, int idade, double salario, EnumDepartamento departamento, double bonus) {
        super(nome, cpf, idade, salario, departamento, bonus);
    }

    @Override
    public void comandar(String comando) {
        System.out.println(comando);
    }
}
