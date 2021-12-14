package main;

import pessoa.Administrador;
import pessoa.Empregado;
import pessoa.Fornecedor;
import pessoa.Operario;

public class main {

    public static void main(String[] args) {
        Operario opr = new Operario("Marcos", "Rua rua", "88888-8888", 3,4000,15,1200,15);

        System.out.println("Setor: "+opr.getCodigoSetor());
        System.out.println("Nome: "+opr.getNome());
        System.out.println("Endereco: "+opr.getEndereco());
        System.out.println("Telefone: "+opr.getTelefone());
        System.out.println("Salario bruto: R$ "+opr.getSalarioBase());
        System.out.println("valor do imposto: "+opr.getImposto()+"%");
        System.out.println("Valor da produção: R$ "+opr.getValorProducao());
        System.out.println("Comissão: "+opr.getComissao()+"%");
        System.out.println("Salario limpo: R$ "+opr.calcularSalario());
    }
}
