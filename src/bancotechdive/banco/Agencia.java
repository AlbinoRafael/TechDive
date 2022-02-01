package bancotechdive.banco;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agencia {
    private String numero;
    private String cidade;

    public Agencia(String numero, String cidade) {
        this.numero = numero;
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    @Override
    public String toString() {
        return numero + " - " + cidade;
    }

    public void gravaAgencia() {
        try (FileWriter fw = new FileWriter("documentos/agencias/agencias.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            String dadosAgencia = this.getNumero() + ";" + this.getCidade();
            Path path = Paths.get("documentos/agencias/agencias.txt");
            if (Files.size(path) == 0) {
                pw.println(dadosAgencia);
            }else{
                if(agenciaExiste()==false){
                    pw.println(dadosAgencia);
                }else{
                    System.err.println("Agencia já existe!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean agenciaExiste() {
        List<String> lista = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("documentos/agencias/agencias.txt"));
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                lista.add(linha);
            }
            for (String s : lista) {
                String[] dados = s.split(";");
                String numero = dados[0];
                String cidade = dados[1];
                if (numero.equals(this.getNumero()) && cidade.equals(this.getCidade())) {
                    return true;
                }
            }
            sc.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
