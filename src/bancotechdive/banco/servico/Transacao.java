package bancotechdive.banco.servico;

import bancotechdive.banco.conta.Conta;
import bancotechdive.banco.conta.ContaCorrente;
import bancotechdive.banco.conta.ContaInvestimento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {

    private Conta conta;
    private Conta contaAlvo;
    private double valor;
    private String data;
    private String tipo;

    public Transacao(Conta conta, double valor) {
        this.conta = conta;
        this.valor = valor;
        this.data = mostraData();
    }

    public Transacao(Conta conta, Conta contaAlvo, double valor) {
        this.conta = conta;
        this.valor = valor;
        this.contaAlvo = contaAlvo;
        this.data = mostraData();
    }

    public Conta getConta() {
        return conta;
    }

    public double getValor() {
        return valor;
    }
    public String getData(){
        return this.data;
    }
    public void setData(String data){
        this.data = data;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Conta getContaAlvo() {
        return contaAlvo;
    }

    public void setContaAlvo(Conta contaAlvo) {
        this.contaAlvo = contaAlvo;
    }

    public String mostraData() {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String data = ldt.format(dtf);
        return data;
    }

    public String toString() {
        //retorna toString da transacao realizada
        String retorno = "";
        //caso seja saque ou deposito
        if (this.getTipo().equalsIgnoreCase("Saque") || this.getTipo().equalsIgnoreCase("Depósito")) {
            retorno = "\n----------- " + this.getTipo().toUpperCase() + " -----------\n\n" +
                    "Id: " + this.getConta().getIdentificador() + " - Agencia: " + this.getConta().getAgencia() + "\n" +
                    "Nome: " + this.getConta().getNome() + "\n" +
                    "CPF: " + this.getConta().getCpf() + "\n" +
                    "Valor: R$ " + this.getValor() + "\n" +
                    "Data: " + this.mostraData() + "\n\n";

        }
        //caso seja conta corrente e estaja com saldo negativo
        else if (this.getTipo().equalsIgnoreCase("Saque") &&
                this.getConta() instanceof ContaCorrente && this.getConta().getSaldo() < 0) {
            ContaCorrente cc = (ContaCorrente) this.getConta();

            retorno = "\n----------- " + this.getTipo().toUpperCase() + " -----------\n\n" +
                    "Id: " + this.getConta().getIdentificador() + " - Agencia: " + this.getConta().getAgencia() + "\n" +
                    "Nome: " + this.getConta().getNome() + "\n" +
                    "CPF: " + this.getConta().getCpf() + "\n" +
                    "Valor: R$ " + this.getValor() + "\n" +
                    "Data: " + this.mostraData() + "\n" +
                    "Data limite: " + cc.limiteChequeEspecial() + "\n\n";

        } else if (this.getTipo().equalsIgnoreCase("Investimento") && this.getConta() instanceof ContaInvestimento) {
            ContaInvestimento ci = (ContaInvestimento) conta;
            retorno = "\n----------- " + this.getTipo().toUpperCase() + " -----------\n\n" +
                    "Tipo do Investimento: " + ci.getInvestimentos().get(ci.getInvestimentos().size() - 1).getTipo() + "\n" +
                    "Id: " + this.getConta().getIdentificador() + " - Agencia: " + this.getConta().getAgencia() + "\n" +
                    "Nome: " + this.getConta().getNome() + "\n" +
                    "CPF: " + this.getConta().getCpf() + "\n" +
                    "Valor: R$ " + this.getValor() + "\n" +
                    "Data: " + this.mostraData() + "\n\n";
        } else {
            retorno = "\n----------- " + this.getTipo().toUpperCase() + " -----------\n\n" +
                    "Id: " + this.getConta().getIdentificador() + " - Agencia: " + this.getConta().getAgencia() + "\n" +
                    "Conta origem: " + this.getConta().getNome() + "\n" +
                    "CPF: " + this.getConta().getCpf() + "\n\n" +
                    "Id: " + this.getContaAlvo().getIdentificador() + " - Agencia: " + this.getContaAlvo().getAgencia() + "\n" +
                    "Conta destino: " + this.getContaAlvo() + "\n" +
                    "CPF: " + this.getContaAlvo().getCpf() + "\n\n" +
                    "Valor: R$ " + this.getValor() + "\n" +
                    "Data: " + this.mostraData() + "\n\n";
        }
        return retorno;
    }
}
