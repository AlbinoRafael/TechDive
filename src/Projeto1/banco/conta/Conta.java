package banco.conta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

abstract class Conta {

    private String nome;
    private String cpf; //(é necessário validar o CPF)
    private double rendaMensal;
    private int identificador; //o sistema deverá gerar um número da conta sequencial
    private Agencia agencia;
    private double saldo;
    private String extrato = "==== Extrato ===\n------------------------------------------------\n";

    public Conta(){
        super();
    }

    public Conta(String nome, String cpf, double rendaMensal, int identificador, Agencia agencia, double saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        this.identificador = identificador;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getExtrato() {
        return extrato;
    }

    public void saque(double valorSaque){
        this.extrato += "Saldo atual:          R$ "+this.saldo+
                      "\nValor do saque:      -R$ "+valorSaque+"\n\n";

        this.saldo-=valorSaque;

        this.extrato += "Valor final:          R$ "+this.saldo+"\n\n"+
                        "DATA: "+this.mostraData()+"\n------------------------------------------------\n";
    }

    public void deposito(double valorDeposito){
        this.extrato += "Saldo atual:          R$ "+this.saldo+
                      "\nValor do depósito:   +R$ "+valorDeposito+"\n\n";

        this.saldo+=valorDeposito;

        this.extrato += "Valor final:          R$ "+this.saldo+"\n\n"+
                        "DATA: "+this.mostraData()+"\n------------------------------------------------\n";
    }

    public double saldo(){
        return this.getSaldo();
    }
    public String extrato(){
        return this.getExtrato();
    }
    public void transferir(Conta contaAlvo, double valorTransferencia){
        if(this.saldo>=valorTransferencia){
            this.extrato += "Saldo atual:               R$ "+this.saldo+
                          "\nValor da transferência:   -R$ "+valorTransferencia+"\n\n";

            this.saldo-=valorTransferencia;

            contaAlvo.deposito(valorTransferencia);

            this.extrato += "Valor final:               R$ "+this.saldo+"\n\n"+
                    "DATA: "+this.mostraData()+"\n------------------------------------------------\n";

        }else{
            System.out.println("Você não possui saldo suficiente!");
        }
    }

    public String mostraData(){
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String data = ldt.format(dtf);
        return data;
    }
}
