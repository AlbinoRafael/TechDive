package bancotechdive.banco.conta;

import bancotechdive.banco.Agencia;
import bancotechdive.banco.servico.Transacao;
import bancotechdive.banco.utils.MsgPadrao;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
    private String tipo;

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

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
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

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
            this.gravaExtrato();
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
                contaAlvo.gravaExtrato();
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

    public void gravaConta() {
        try (FileWriter fw = new FileWriter("documentos/contas/contas.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            String dadosConta = String.format(Locale.US, "%s;%05d;%.2f;%s;%s;%.2f", this.getTipo(), this.getIdentificador(), this.getSaldo(), this.getNome(), this.getCpf(), this.getRendaMensal());
            Path path = Paths.get("documentos/contas/contas.txt");
            if (Files.size(path) == 0) {
                pw.println(dadosConta);
            } else {
                if (contaExiste() == false) {
                    pw.println(dadosConta);
                } else {
                    System.err.println("Conta ja existe!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean contaExiste() {
        List<String> lista = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("documentos/contas/contas.txt"));
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                lista.add(linha);
            }
            for (String s : lista) {
                String[] dados = s.split(";");
                String nome = dados[3];
                String cpf = dados[4];
                if (nome.equals(this.getNome()) && cpf.equals(this.getCpf())) {
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

    public void gravaExtrato(){
        try (FileWriter fw = new FileWriter("documentos/transacoes/"+this.getNome()+".txt", false);
             PrintWriter pw = new PrintWriter(fw)) {
            String extrato = "";
            for(Transacao t: this.transacoes) {
                extrato+=t;
            }
            pw.println(extrato);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void leExtrato(){
        try{
            Scanner sc = new Scanner(new File("documentos/transacoes/"+this.getNome()+".txt"));
            String extrato = null;
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                extrato+=linha;
            }
            this.setExtrato(extrato);
        }catch(Exception e){
            System.out.println("A conta não possui transacoes!");;
        }
    }
}
