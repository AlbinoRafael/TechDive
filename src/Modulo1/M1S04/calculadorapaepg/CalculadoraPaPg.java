package calculadorapaepg;

import java.util.Scanner;

public class CalculadoraPaPg {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("\nDigite o valor inicial: ");
        int vlrInicial = sc.nextInt();
        System.out.print("Digite o valor da raiz: ");
        int vlrRaiz = sc.nextInt();

        System.out.print("Você deseja calcular o 10 primeiros número de uma PA ou PG(responda com PA ou PG): ");
        String progressao = sc.next();
        int pa = vlrInicial;
        int pg = vlrInicial;

        if(progressao.equalsIgnoreCase("PA")){
            String saidaPA = vlrInicial+"";
            for (int i=0; i<10; i++){
                pa += vlrRaiz;
                saidaPA += ", "+pa;
            }
            System.out.println("\nO resultado da PA é: "+saidaPA);
        }else if (progressao.equalsIgnoreCase("PG")){
            String saidaPG = vlrInicial+"";
            for (int i=0; i<10; i++){
                pg *= vlrRaiz;
                saidaPG += ", "+pg;
            }
            System.out.println("\nO resultado da PG é: "+saidaPG);
        }
    }
}
