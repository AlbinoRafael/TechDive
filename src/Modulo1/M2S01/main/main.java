package main;

import pessoa.Empregado;
import pessoa.Fornecedor;

public class main {

    public static void main(String[] args) {
        Empregado emp = new Empregado("Joao", "Rua mais nova", "98989-8989",3, 2000,10);

        System.out.println(emp.toString());
        System.out.println("Setor: "+emp.getCodigoSetor());
        System.out.println("Salario base: R$"+emp.getSalarioBase());
        System.out.println("Taxa de imposto: "+emp.getImposto()+"%");
        System.out.println("Salario limpo: R$ "+emp.calcularSalario());

    }
}
