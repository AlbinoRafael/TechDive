package lecaractereeapresentaquantasvezesaparece;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LeCaractereEMostraQuantasVezesAparece {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Path path = Paths.get("Teste.txt");
        try (BufferedReader br = Files.newBufferedReader(path)) {
            System.out.print("Digite um caractere a ser buscado: ");
            String caractere = sc.nextLine();
            int contaCaractere = 0;
            String linha = br.readLine();
            char[] caracteres = linha.toCharArray();
            while (linha != null) {
                for (int i = 0; i < caracteres.length; i++) {
                    if (caracteres[i] == caractere.charAt(0)) {
                        contaCaractere++;
                    }
                }
                linha = br.readLine();
            }
            System.out.println("o caractere '" + caractere + "', apareceu " + contaCaractere + " vez(es)");
        }
    }
}
