package main;

import pessoa.*;

public class main {

    public static void main(String[] args) {
        Vendedor vnd = new Vendedor("Marcos", "Rua rua", "88888-8888", 1,1700,10,2200,15);

        System.out.println("Setor: "+vnd.getCodigoSetor());
        System.out.println("Nome: "+vnd.getNome());
        System.out.println("Endereco: "+vnd.getEndereco());
        System.out.println("Telefone: "+vnd.getTelefone());
        System.out.println("Salario bruto: R$ "+vnd.getSalarioBase());
        System.out.println("valor do imposto: "+vnd.getImposto()+"%");
        System.out.println("Valor das vendas: R$ "+vnd.getValorVendas());
        System.out.println("Comissão: "+vnd.getComissao()+"%");
        System.out.println("Salario limpo: R$ "+vnd.calcularSalario());
    }
}
