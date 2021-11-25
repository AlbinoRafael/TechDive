package imc;

import java.util.Locale;
import java.util.Scanner;

public class IMC {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o seu peso em Kg (Ex: 50.0): ");
		double peso = Double.parseDouble(sc.next());
		System.out.print("Digite sua altura em m (Ex: 1.70): ");
		double altura = Double.parseDouble(sc.next());
		
		double imc = peso/(altura*altura);
		
		System.out.println();
		System.out.printf("Seu imc é de %.2f", imc);
	}

}
