package nomeusuario;

import java.util.Scanner;

public class NomeUsuario {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Qual seu nome?: ");
		String nome = sc.nextLine();
		System.out.print("Qual seu sobrenome?: ");
		String sobrenome = sc.nextLine();

		String nomeCompleto = nome+" "+sobrenome;

		int qtdLetras = 0;

		for(int i = 0; i < nomeCompleto.length(); i++){
			if(nomeCompleto.charAt(i) != ' '){
				qtdLetras++;
			}
		}
		//int qtdLetras = nomeCompleto.length() - cont;

		System.out.println();
		System.out.println(nomeCompleto+", seu nome possui "+qtdLetras+" letras!");
	}

}
