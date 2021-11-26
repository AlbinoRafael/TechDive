package calculadora;

import java.util.Locale;
import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.print("\nDigite o primeiro número: ");
        double numero1 = sc.nextDouble();
        System.out.print("Digite o segundo número: ");
        double numero2 = sc.nextDouble();
        System.out.print("Digite a operação a ser realizada(+,-,*,/): ");
        char operacao = sc.next().charAt(0);
        double resultado = 0;

        switch(operacao){
            case '+':
                resultado = numero1 + numero2;
                System.out.println("\nO resultado da operação é "+resultado);
                break;
            case '-':
                resultado = numero1 - numero2;
                System.out.println("\nO resultado da operação é "+resultado);
                break;
            case '*':
                resultado = numero1 * numero2;
                System.out.println("\nO resultado da operação é "+resultado);
                break;
            case '/':
                resultado = numero1 / numero2;
                System.out.println("\nO resultado da operação é "+resultado);
                break;
            default:
                System.out.println("\nInforme uma operação válida!!");
        }
    }
}
