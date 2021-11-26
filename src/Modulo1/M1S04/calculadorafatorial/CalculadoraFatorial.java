package calculadorafatorial;

import java.util.Scanner;

public class CalculadoraFatorial {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número de 0 a 10: ");
        int numero = sc.nextInt();
        int fatorial = 1;

        if(numero > -1 && numero < 11){
            for(int i=numero; i>0; i--){
                fatorial*=i;
            }
            System.out.println("\nO fatorial de "+numero+" é: "+fatorial);
        }else{
            System.out.println("\nDigite um valor válido!!");
        }
    }
}
