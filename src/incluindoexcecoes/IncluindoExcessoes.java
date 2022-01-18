package incluindoexcecoes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IncluindoExcessoes {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean repete;
        do {
            repete = false;
            try {
                System.out.println("\nEu sei dividir!");
                System.out.print("Informe o primeiro valor: ");
                int x = teclado.nextInt();
                System.out.print("Informe o segundo valor: ");
                int y = teclado.nextInt();
                double r = (double)x /(double) y;
                System.out.println("Resultado da divisão: " + r);
            }catch (InputMismatchException e){
                System.err.println("Entrada inválida! tente novamente!");
                teclado.nextLine();
                repete = true;
            }
        }while(repete);
    }
}
