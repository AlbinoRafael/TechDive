package bancotechdive.banco;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Agencia {
    private String numero;
    private String cidade;

    public Agencia(){
        super();
    }
    public Agencia(String numero, String cidade){
        this.numero = numero;
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return numero +" - "+cidade;
    }

    public void gravaAgencia(){
        try(FileWriter fw = new FileWriter("documentos/agencias/agencias.txt",true);
            PrintWriter pw = new PrintWriter(fw)) {
            String dadosAgencia = this.getNumero() + ";" + this.getCidade();
            pw.println(dadosAgencia);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
