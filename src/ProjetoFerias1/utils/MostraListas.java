package utils;

import funcionarios.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MostraListas {

    public static String listar(List<Funcionario>lista, int op) {
        String itens = "";

        switch (op) {
            case 1:
                int index = 0;
                for (int i = 0; i < lista.size(); i++) {
                    itens += index+1 + " - " + lista.get(i).getNome() + "\n";
                    index++;
                }
                break;
            case 2:
                index = 0;
                for (int i = 0; i < lista.size(); i++) {
                    if(lista.get(i).estaAtivo()==true) {
                        itens += index+1 + " - " + lista.get(i).getNome() + "\n";
                        index++;
                    }

                }
                if(index==0){
                    itens = "Nenhum funcionário está ATIVO";
                }
                break;
            case 3:
                index = 0;
                for (int i = 0; i < lista.size(); i++) {
                    if(lista.get(i).estaAtivo()==false) {
                        itens += index+1 + " - " + lista.get(i).getNome() + "\n";
                        index++;
                    }

                }
                if(index==0){
                    itens = "Nenhum funcionário foi DESATIVADO";
                }
                break;
        }
        return itens;
    }

    public static Funcionario escolheFuncionario(List<Funcionario>lista){
        String retorno = "";
        int index = 0;
        for(Funcionario f: lista){
            retorno += index+1+" - "+ f.getNome()+"\n";
            index++;
        }
        if(index == 0){
            retorno = "Nenhum funcionário encontrado!";
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("\n------------Lista de Funcionarios------------\n\n"+retorno);
        System.out.print("Selecione um funcionário acima: ");
        int op = sc.nextInt();
        return lista.get(op-1);
    }

    public static Funcionario escolheFuncionarioAtivo(List<Funcionario>lista){
        List<Funcionario>funcAtivos = new ArrayList<>();
        String listaFuncAtivos= "";
        int index = 0;
        for(int i = 0; i<lista.size();i++){
            if(lista.get(i).estaAtivo()==true){
                funcAtivos.add(lista.get(i));
            }
        }
        for(int i = 0; i<funcAtivos.size();i++){
            listaFuncAtivos+= index+1 +" - "+ funcAtivos.get(i).getNome()+"\n";
            index++;
        }
        if(index == 0){
            listaFuncAtivos = "Nenhum funcionário ATIVO!\n";
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("\n------------Lista de Funcionarios ATIVOS------------\n\n"+listaFuncAtivos);
        System.out.print("Selecione um funcionário acima: ");
        int op = sc.nextInt();
        return funcAtivos.get(op-1);
    }
}
