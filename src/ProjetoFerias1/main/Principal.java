package main;

import funcionarios.*;
import utils.Menu;
import utils.MostraListas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static List<Funcionario> funcionarios = new ArrayList<>();

    static{
        Colaborador colaborador1 = new Colaborador("Joao","4523452345",18,1500,EnumDepartamento.DEPARTAMENTO5,300);
        Colaborador colaborador2 = new Colaborador("Pedro","75245645",33,1500,EnumDepartamento.DEPARTAMENTO5,300);
        Colaborador colaborador3 = new Colaborador("Paulo","3457345",23,1500,EnumDepartamento.DEPARTAMENTO5,300);
        Colaborador colaborador4 = new Colaborador("Maria","23452345234",35,1500,EnumDepartamento.DEPARTAMENTO5,300);
        Colaborador colaborador5 = new Colaborador("Joana","6456734564",21,1500,EnumDepartamento.DEPARTAMENTO5,300);
        LiderTecnico lider1 = new LiderTecnico("Marcos","23453236423",25,2500,EnumDepartamento.DEPARTAMENTO5, 300);
        GerenteDepartamento gd1 = new GerenteDepartamento("Ana", "3451231253",35,3500,EnumDepartamento.DEPARTAMENTO5,500);
        GerenteGeral gg = new GerenteGeral("Antônio", "3435342346", 45,4500, EnumDepartamento.DEPARTAMENTO6, 600);
        funcionarios.add(colaborador1);
        funcionarios.add(colaborador2);
        funcionarios.add(colaborador3);
        funcionarios.add(colaborador4);
        funcionarios.add(colaborador5);
        funcionarios.add(lider1);
        funcionarios.add(gd1);
        funcionarios.add(gg);


    }

    public static void main(String[] args) {
        menuPrincipal();
    }


    public static void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
            Menu.menuPrincipal();
            System.out.print("Digite uma opção acima: ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    Menu.menuAdicionaFuncionario();
                    System.out.print("Digite uma opção acima: ");
                    int op = sc.nextInt();
                    adicionaFuncionario(op);
                    break;
                case 2:
                    if (!funcionarios.isEmpty()) {
                        detalhesFuncionario();
                    } else {
                        System.out.println("\nSem Funcionarios cadastrados!");
                    }
                    break;
                case 3:
                    if (!funcionarios.isEmpty()) {
                        demiteFuncionario();
                    } else {
                        System.out.println("\nSem Funcionarios cadastrados!");
                    }
                    break;
                case 4:
                    if(!funcionarios.isEmpty()){
                        atualizaInformacoesFuncionario();
                    }else{
                        System.out.println("\nSem Funcionários cadastrados!");
                    }
                    break;
                case 0:
                    break;
            }
        } while (opcao != 0);
    }

    public static void adicionaFuncionario(int op) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n------- Informações do Funcionário -------");

        System.out.print("\nDigite o nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite o cpf: ");
        String cpf = sc.nextLine();

        System.out.print("Digite a idade: ");
        int idade = sc.nextInt();

        System.out.print("Digite o salário: R$ ");
        double salario = sc.nextDouble();
        switch (op) {
            case 1:
                System.out.print("Digite o valor dos benefícios: R$ ");
                double beneficios = sc.nextDouble();
                Colaborador colaborador = new Colaborador(nome, cpf, idade, salario, null, beneficios);
                colaborador.defineDepartamento();
                funcionarios.add(colaborador);
                break;
            case 2:
                System.out.print("Digite o valor dos benefícios: R$ ");
                beneficios = sc.nextDouble();
                LiderTecnico lider = new LiderTecnico(nome, cpf, idade, salario, null, beneficios);
                lider.defineDepartamento();
                funcionarios.add(lider);
                break;
            case 3:
                System.out.print("Digite o valor do bônus: R$ ");
                double bonus = sc.nextDouble();
                GerenteDepartamento gd = new GerenteDepartamento(nome, cpf, idade, salario, null, bonus);
                gd.defineDepartamento();
                funcionarios.add(gd);
                break;
            case 4:
                System.out.print("Digite o valor do bônus: R$ ");
                bonus = sc.nextDouble();
                GerenteGeral gg = new GerenteGeral(nome, cpf, idade, salario, null, bonus);
                gg.defineDepartamento();
                funcionarios.add(gg);
                break;
        }
    }

    public static void detalhesFuncionario() {
        Funcionario funcionario = MostraListas.escolheFuncionario(funcionarios);
        System.out.println(funcionario.toString());
    }

    public static void demiteFuncionario(){
        Funcionario funcionario = MostraListas.escolheFuncionario(funcionarios);
        funcionario.setEstaAtivo(false);
    }

    public static void atualizaInformacoesFuncionario(){
        Scanner sc = new Scanner(System.in);
        Funcionario funcionario = MostraListas.escolheFuncionario(funcionarios);
        Menu.menuAtualizaInformacoesFuncionario();
        int op= sc.nextInt();
        sc.nextLine();
        switch (op){
            case 1:
                System.out.println("Nome atual do Funcionario: "+funcionario.getNome());
                System.out.print("Digite o novo nome: ");
                String novoNome = sc.nextLine();
                funcionario.setNome(novoNome);
                break;
            case 2:
                System.out.println("Idade atual do Funcionario: "+funcionario.getIdade());
                System.out.print("Digite a nova idade: ");
                int novaIdade = sc.nextInt();
                funcionario.setIdade(novaIdade);
                break;
            case 3:
                System.out.println("Salário atual do Funcionario: "+funcionario.getSalario());
                System.out.print("Digite o novo salário: ");
                double novoSalario = sc.nextDouble();
                funcionario.setSalario(novoSalario);
                break;
            case 4:
                System.out.println("Departamento atual do Funcionario: "+funcionario.getDepartamento());
                System.out.println("Escolha o novo departamento: ");
                funcionario.defineDepartamento();
                break;
            case 5:
                if(funcionario instanceof Colaborador) {
                    System.out.println("Valor atual dos benefícios: R$ " + ((Colaborador) funcionario).getBeneficios());
                    System.out.println("Digite o novo valor dos benefícios: R$ ");
                    double novoValorBeneficios = sc.nextDouble();
                    ((Colaborador) funcionario).setBeneficios(novoValorBeneficios);
                }else if(funcionario instanceof LiderTecnico) {
                    System.out.println("Valor atual dos benefícios: R$ " + ((LiderTecnico) funcionario).getBeneficios());
                    System.out.println("Digite o novo valor dos benefícios: R$ ");
                    double novoValorBeneficios = sc.nextDouble();
                    ((LiderTecnico) funcionario).setBeneficios(novoValorBeneficios);
                }else if(funcionario instanceof GerenteGeral) {
                    System.out.println("Valor atual dos bonificações: R$ " + ((GerenteGeral) funcionario).getBonus());
                    System.out.println("Digite o novo valor das bonificações: R$ ");
                    double novoValorBonus = sc.nextDouble();
                    ((GerenteGeral) funcionario).setBonus(novoValorBonus);
                }else if(funcionario instanceof GerenteDepartamento) {
                    System.out.println("Valor atual dos bonificações: R$ " + ((GerenteDepartamento) funcionario).getBonus());
                    System.out.println("Digite o novo valor das bonificações: R$ ");
                    double novoValorBonus = sc.nextDouble();
                    ((GerenteDepartamento) funcionario).setBonus(novoValorBonus);
                }
                break;
            case 6:
                System.out.println("Situacão atual do Funcionario: "+funcionario.estaAtivo(funcionario.estaAtivo()));
                System.out.print("Digite a nova situação do Funcionário(A-Ativo | D-Desativado): ");
                String novaSituação = sc.next();
                if(novaSituação.equalsIgnoreCase("A")){
                    funcionario.setEstaAtivo(true);
                }else if(novaSituação.equalsIgnoreCase("D")){
                    funcionario.setEstaAtivo(false);
                }else{
                    System.out.println("Opção inválida!");
                }
                break;
        }
    }
}
