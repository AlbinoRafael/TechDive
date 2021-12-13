package banco.utils;
import banco.conta.Conta;
import banco.conta.ContaInvestimento;
import banco.conta.ContaPoupanca;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MostraListas {

    private MostraListas() {
        super();
    }

    public static Object mostraItens(List<?> lista) {
        Scanner sc = new Scanner(System.in);
        String listaPronta = "\n";
        if (!lista.isEmpty()) {
            int index = 1;
            for (Object obj : lista) {
                listaPronta += index + " - " + obj.toString() + "\n";
                index++;
            }
            listaPronta += "\n";
            System.out.print(listaPronta + "Selecione uma opção(apenas números): ");
            int opcao = sc.nextInt();
            if (opcao > 0 && opcao <= index) {
                return lista.get(opcao - 1);
            } else {
                return null;
            }
        }else{
            return null;
        }
    }

    public static Conta contasTotal(List<Conta> contas) {
        Scanner sc = new Scanner(System.in);
        String listaPronta = "";
        int index = 1;

        for (Conta conta:contas) {
            listaPronta += index + " - " + conta.toString() + "\n";
            index++;
        }
        listaPronta += "\n";
        System.out.print("\n" + listaPronta + "\nSelecione uma opção(apenas números): ");
        int opcao = sc.nextInt();
        return contas.get(opcao - 1);
    }

    public static List<Conta>contasInvestimento(List<Conta>lista){
        List<Conta>listInv = new ArrayList<>();
        for(Conta conta: lista){
            if(conta instanceof ContaInvestimento){
                listInv.add(conta);
            }
        }
        return listInv;
    }

    public static List<Conta>contasPoupanca(List<Conta>lista){
        List<Conta>listInv = new ArrayList<>();
        for(Conta conta: lista){
            if(conta instanceof ContaPoupanca){
                listInv.add(conta);
            }
        }
        return listInv;
    }

}
