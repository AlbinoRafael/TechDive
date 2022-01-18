package banco;

import banco.contas.ContaCorrente;
import banco.contas.ContaPoupanca;

public class Banco {

    public static void main(String[] args) {

        Agencia agencia1 = new Agencia("5555-4","Florianópolis");
        agencia1.adicionaConta(new ContaCorrente("José da Silva", "11233456789"));
        agencia1.adicionaConta(new ContaPoupanca("Maria dos Santos", "41125235654"));

        System.out.println("Número de contas da agência: "+agencia1.getQuantidadeDeContas());


    }
}
