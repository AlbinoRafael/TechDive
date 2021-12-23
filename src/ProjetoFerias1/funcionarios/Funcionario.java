package funcionarios;

import utils.Menu;

import java.util.Scanner;

public abstract class Funcionario {

    private String nome;
    private String cpf;
    private int idade;
    private double salario;
    private boolean estaAtivo;
    private EnumDepartamento departamento;

    public Funcionario(){}

    public Funcionario(String nome, String cpf, int idade, double salario, EnumDepartamento departamento){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.salario = salario;
        this.estaAtivo = true;
        this.departamento = departamento;
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

    public void setSalario(double valor){this.salario = valor;}



    public EnumDepartamento getDepartamento(){
        return this.departamento;
    }

    public void setDepartamento(EnumDepartamento departamento){
        this.departamento = departamento;
    }

    public void defineDepartamento() {
        Scanner sc = new Scanner(System.in);
        Menu.menuDefineDepartamento();
        System.out.print("Selecione o departamento: ");
        int op = sc.nextInt();
        switch (op) {
            case 1:
                this.setDepartamento(EnumDepartamento.DEPARTAMENTO1);
                break;
            case 2:
                this.setDepartamento(EnumDepartamento.DEPARTAMENTO2);
                break;
            case 3:
                this.setDepartamento(EnumDepartamento.DEPARTAMENTO3);
                break;
            case 4:
                this.setDepartamento(EnumDepartamento.DEPARTAMENTO4);
                break;
            case 5:
                this.setDepartamento(EnumDepartamento.DEPARTAMENTO5);
                break;
        }
    }

    public boolean estaAtivo(){
        return estaAtivo;
    }
    public String estaAtivo(Boolean isAtivo){
        String situacao = "Ativo";
        if(isAtivo == false){
            situacao = "Dasativado";
        }
        return situacao;
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
