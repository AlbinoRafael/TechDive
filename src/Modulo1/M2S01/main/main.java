package main;

import pessoa.Funcionario;

public class main {

    public static void main(String[] args) {
        Funcionario f = new Funcionario("Pedro", "Rua nova", "00000-0000",
                1000, 500);


        System.out.println(f.toString());

        f.setNome("Marcos");
        f.setEndereco("Rua sem nome");
        f.setTelefone("00000-0000");
        System.out.println(f.toString());

        System.out.println("Valor do saldo: R$ "+f.obterSaldo());

    }
}
