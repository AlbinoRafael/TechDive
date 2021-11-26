package adivinhanumero;

import java.util.Random;
import java.util.Scanner;

public class AdivinhaNumero {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Random rd = new Random();
		int x = rd.nextInt(5) + 1;

		System.out.print("Qual número estou pensando?(entre 1 e 5): ");
		int numero = sc.nextInt();

		System.out.println(numero == x ? "Você acertou!!":"Você errou!! o número correto era " + x + " !!");

	}

}
