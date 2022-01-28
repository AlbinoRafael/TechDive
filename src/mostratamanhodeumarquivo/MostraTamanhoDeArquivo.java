package mostratamanhodeumarquivo;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class MostraTamanhoDeArquivo {

    public static void main(String[] args) throws IOException {
            File file = new File("Teste.txt");
            long tamanhoEmBytes = file.length();
            double tamanhoEmKb = tamanhoEmBytes / 1000;
            double tamanhoEmMb = tamanhoEmKb / 1024;
            System.out.println("tamanho em Bytes: " + tamanhoEmBytes);
            System.out.printf(Locale.US, "tamanho em Kilobytes: %.2f %n", tamanhoEmKb);
            System.out.println("tamanho em Megabytes: " + tamanhoEmMb);
    }
}
