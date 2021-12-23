package funcionarios;

public class GerenteGeral extends Gerente{

    public GerenteGeral(String nome, String cpf, int idade, double salario, EnumDepartamento departamento, double bonus) {
        super(nome, cpf, idade, salario, departamento, bonus);
    }

    @Override
    public void comandar(String comando) {
        System.out.println(comando);
    }
}
