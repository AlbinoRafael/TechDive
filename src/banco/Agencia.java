package banco;

import banco.contas.Conta;

import java.util.ArrayList;
import java.util.List;

public class Agencia {

    private List<Conta> contas = new ArrayList<>();
    private String numeroAgencia;
    private String enderecoAgencia;

    private Agencia(){}

    public Agencia(String numeroAgencia, String enderecoAgencia) {
        this.numeroAgencia = numeroAgencia;
        this.enderecoAgencia = enderecoAgencia;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public String getEnderecoAgencia() {
        return enderecoAgencia;
    }

    public void adicionaConta(Conta c){
        contas.add(c);
        System.out.println("Conta adicionada com sucesso!");
    }
    public int getQuantidadeDeContas(){
        return contas.size();
    }
}
