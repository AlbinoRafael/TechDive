package main;

import pessoa.Administrador;
import pessoa.Empregado;
import pessoa.Fornecedor;

public class main {

    public static void main(String[] args) {
        Administrador adm = new Administrador("Marcos", "Rua rua", "88888-8888", 3,4000,15,560);

        System.out.println("Setor: "+adm.getCodigoSetor());
        System.out.println("Nome: "+adm.getNome());
        System.out.println("Endereco: "+adm.getEndereco());
        System.out.println("Telefone: "+adm.getTelefone());
        System.out.println("Salario bruto: R$ "+adm.getSalarioBase());
        System.out.println("valor do imposto: "+adm.getImposto()+"%");
        System.out.println("Ajuda de custo: R$ "+adm.getAjudaDeCusto());
        System.out.println("Salario limpo: R$ "+adm.calcularSalario());
    }
}
