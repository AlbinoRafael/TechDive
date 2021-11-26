package calculamediafinal;

import java.util.Locale;
import java.util.Scanner;

public class CalculaMediaFinal {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);//usa o padrão americano, usando . para separar números decimais

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a seguir as 3 notas \n");

		System.out.print("Digite a nota 1: ");
		double nota1 = sc.nextDouble();
		
		System.out.print("Digite a nota 2: ");
		double nota2 = sc.nextDouble();
		
		System.out.print("Digite a nota 3: ");
		double nota3 = sc.nextDouble();

		double media = (nota1+nota2+nota3)/3;
		System.out.printf("%nSua média final é %.2f", media);
		
		
	}

}
