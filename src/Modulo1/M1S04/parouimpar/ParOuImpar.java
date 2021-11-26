package parouimpar;

import java.util.Scanner;

public class ParOuImpar {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite um número: ");
		int numero = sc.nextInt();
		
		System.out.println();
		if(numero%2 == 0) {
			System.out.println("o número "+numero+" é PAR");
		}else {
			System.out.println("o número "+numero+" é IMPAR");
		}
	}

}
