package banco.conta;

import banco.Agencia;
import banco.servico.Transacao;
import banco.utils.MsgPadrao;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Conta {
    private List<Transacao> transacoes = new ArrayList<>();
    private static int id;
    private String nome;
    private String cpf;
    private double rendaMensal;
    private int identificador;
    private double saldo;
    private Agencia agencia;
    private String extrato;

    public Conta() {
        super();
        this.identificador = id + 1;
        id++;
    }

    public Conta(String nome, String cpf, double rendaMensal) {
        this.nome = nome;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        this.saldo = 0;
        this.identificador = id;
        id++;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
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

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getExtrato() {
        return extrato;
    }

    public void setExtrato(String extrato) {
        if (this.extrato == null) {
            this.extrato = extrato;
        } else {
            this.extrato += extrato;
        }
    }

    public String extrato() {
        String extrato = "\n----------- Extrato -----------\n";
        extrato += this.getExtrato();
        return extrato;
    }

    public void saque(double valorSaque) {
            Transacao transacao = new Transacao(this, valorSaque);
            transacao.setTipo("Saque");
            transacao.setValor(valorSaque);
            this.setSaldo(this.getSaldo() - transacao.getValor());
            this.setExtrato(transacao.toString());
            this.getTransacoes().add(transacao);
    }

    public void deposito(double valorDeposito) {
        if (valorDeposito > 0) {
            Transacao transacao = new Transacao(this, valorDeposito);
            transacao.setTipo("Depósito");
            transacao.setValor(valorDeposito);
            this.setSaldo(this.getSaldo() + transacao.getValor());
            this.setExtrato(transacao.toString());
            this.getTransacoes().add(transacao);
        } else {
            MsgPadrao.mensagem("Insira um valor válido!");
        }
    }

    public void transferir(Conta contaAlvo, double valorTransferencia) {
        if (this.getSaldo() >= valorTransferencia) {
            if (this != contaAlvo) {
                Transacao transacao = new Transacao(this, contaAlvo, valorTransferencia);
                transacao.setTipo("Transferência");
                transacao.setContaAlvo(contaAlvo);
                transacao.setValor(valorTransferencia);
                this.setSaldo(this.getSaldo() - transacao.getValor());
                contaAlvo.setSaldo(contaAlvo.getSaldo() + valorTransferencia);
                this.setExtrato(transacao.toString());
                contaAlvo.setExtrato(transacao.toString());
                this.getTransacoes().add(transacao);
                contaAlvo.getTransacoes().add(transacao);
            } else {
                MsgPadrao.mensagem("A conta de origem e a de destino não podem ser a mesma!");
            }
        } else {
            MsgPadrao.mensagem("Você não possui saldo suficiente!");
        }
    }

    public String toString() {
        return this.getNome();
    }
}
