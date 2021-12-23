package main;

import funcionarios.*;
import utils.Menu;
import utils.MostraListas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static List<Funcionario> funcionarios = new ArrayList<>();

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
                        detalhesFuncionario(funcionarios);
                    } else {
                        System.out.println("\nSem Funcionarios cadastrados!");
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
                bonus = sc.nextDouble();
                GerenteGeral gg = new GerenteGeral(nome, cpf, idade, salario, null, bonus);
                gg.defineDepartamento();
                funcionarios.add(gg);
                break;
        }
    }

    public static void detalhesFuncionario(List<Funcionario> funcionarios) {
        Funcionario funcionario = MostraListas.escolheFuncionario(funcionarios);
        System.out.println(funcionario.toString());
    }
}
