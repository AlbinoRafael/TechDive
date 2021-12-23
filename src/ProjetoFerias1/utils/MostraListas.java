package utils;

import funcionarios.Funcionario;

import java.util.List;
import java.util.Scanner;

public class MostraListas {

    public static String listar(List<?>lista){
        String itens = "";
        for(int i=0; i<lista.size();i++){
            itens+=lista.get(i).toString()+"\n";
        }
        return itens;
    }
    public static Funcionario escolheFuncionario(List<Funcionario>lista){
        String retorno = "";
        int index = 1;
        for(Funcionario f: lista){
            retorno += index+" - "+ f.getNome()+"\n";
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("\n------------Lista de Funcionarios------------\n\n"+retorno);
        System.out.print("Selecione um funcionário acima: ");
        int op = sc.nextInt();
        return lista.get(op-1);
    }
}
