package banco;

import banco.cliente.Cliente;
import banco.contas.Conta;
import banco.contas.ContaCorrente;
import banco.contas.ContaPoupanca;

import java.util.Scanner;

public class Banco {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agencia agencia1 = new Agencia("5555-4","Florianópolis");
        agencia1.adicionaConta(new ContaCorrente(new Cliente("José da Silva", "11233456789")));
        agencia1.adicionaConta(new ContaPoupanca(new Cliente("Maria dos Santos", "41125235654")));
        System.out.println("Número de contas da agência: "+agencia1.getQuantidadeDeContas());

        System.out.print("digite o nome a ser buscado: ");
        String nomeBusca = sc.nextLine();
        Conta buscaConta = agencia1.buscaPorTitular(nomeBusca);
        if(buscaConta!=null){
            System.out.println("A conta foi encontrada!");
        }else{
            System.out.println("Nenhuma conta encontrada!");
        }



    }
}
