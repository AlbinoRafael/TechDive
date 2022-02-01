package bancotechdive.banco.conta;

import bancotechdive.banco.Agencia;
import bancotechdive.banco.Banco;
import bancotechdive.banco.servico.Transacao;
import bancotechdive.banco.utils.MsgPadrao;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        String extrato = "\n----------- Extrato -----------\n\n";
        extrato += this.getExtrato();
        return extrato;
    }

    public void saque(double valorSaque) {
        if (this.getSaldo() > 0) {
            Transacao transacao = new Transacao(this, valorSaque);
            transacao.setTipo("Saque");
            transacao.setValor(valorSaque);
            this.setSaldo(this.getSaldo() - transacao.getValor());
            this.setExtrato(transacao.toString());
            this.getTransacoes().add(transacao);
            gravaTransacao(transacao);
        }
    }

    public void deposito(double valorDeposito) {
        if (valorDeposito > 0) {
            Transacao transacao = new Transacao(this, valorDeposito);
            transacao.setTipo("Depósito");
            transacao.setValor(valorDeposito);
            this.setSaldo(this.getSaldo() + transacao.getValor());
            this.setExtrato(transacao.toString());
            this.getTransacoes().add(transacao);
            gravaTransacao(transacao);
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
                gravaTransacao(transacao);
                contaAlvo.gravaTransacao(transacao);
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
            String dadosConta = String.format(Locale.US, "%s;%05d;%.2f;%s;%s;%.2f;%s;%s", this.getTipo(), this.getIdentificador(), this.getSaldo(), this.getNome(), this.getCpf(), this.getRendaMensal(), this.getAgencia().getNumero(), this.getAgencia().getCidade());
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

    public void gravaTransacao(Transacao t) {
        try (FileWriter fw = new FileWriter("documentos/transacoes/" + this.getNome() + ".txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            String dadosTransacao = "";
            if (t.getTipo().equals("Saque") || t.getTipo().equals("Depósito") || t.getTipo().equals("Investimento")) {
                dadosTransacao = String.format(Locale.US, "%s;%s;%.2f;%s;%s", t.getTipo(), t.getConta().getNome(), t.getValor(), t.getData(), null);
            } else if (t.getTipo().equals("Transferência")) {
                dadosTransacao = String.format(Locale.US, "%s;%s;%.2f;%s;%s", t.getTipo(), t.getConta().getNome(), t.getValor(), t.getData(), t.getContaAlvo().getNome());
            }
            pw.println(dadosTransacao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void regravaTransacoes() {
        try (FileWriter fw = new FileWriter("documentos/transacoes/" + this.getNome() + ".txt", false);
             PrintWriter pw = new PrintWriter(fw)) {
            if (!transacoes.isEmpty()) {
                for (Transacao t : transacoes) {
                    String dadosTransacao = "";
                    if (t.getTipo().equals("Saque") || t.getTipo().equals("Depósito") || t.getTipo().equals("Investimento")) {
                        dadosTransacao = String.format(Locale.US, "%s;%s;%.2f;%s;%s", t.getTipo(), t.getConta().getNome(), t.getValor(), t.getData(), null);
                    } else if (t.getTipo().equals("Transferência")) {
                        dadosTransacao = String.format(Locale.US, "%s;%s;%.2f;%s;%s", t.getTipo(), t.getConta().getNome(), t.getValor(), t.getData(), t.getContaAlvo().getNome());
                    }
                    pw.println(dadosTransacao);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void carregaTransacoes() {
        List<String> lista = new ArrayList<>();
        try {
            File file = new File("documentos/transacoes/" + this.getNome() + ".txt");
            if (file.exists()) {
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String linha = sc.nextLine();
                    lista.add(linha);
                }
                for (String s : lista) {
                    String[] dados = s.split(";");
                    String tipo = dados[0];
                    String contaAtual = dados[1];
                    double valor = Double.parseDouble(dados[2]);
                    String data = dados[3];
                    String contaAlvo = dados[4];
                    if (tipo.equals("Saque") || tipo.equals("Depósito") || tipo.equals("Investimento")) {
                        if (this.getNome().equals(contaAtual)) {
                            Transacao t = new Transacao(this, valor);
                            t.setData(data);
                            this.getTransacoes().add(t);
                        }
                    } else if (tipo.equals("Transferência")) {
                        for (Conta c : Banco.listaDeContas()) {
                            if (this.getNome().equals(contaAtual)) {
                                if (c.getNome().equals(contaAlvo)) {
                                    Transacao t = new Transacao(this, c, valor);
                                    t.setData(data);
                                    this.getTransacoes().add(t);
                                }
                            }
                        }
                    }
                }
                sc.close();
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void gravaExtrato() {
        try (FileWriter fw = new FileWriter("documentos/extratos/" + this.getNome() + ".txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            String dadosExtrato = "";
            for (Transacao t : transacoes) {
                dadosExtrato = t.toString();
            }
            pw.println(dadosExtrato);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verificaArquivosExtrato() throws IOException {
        for (Conta conta : Banco.listaDeContas()) {
            if (conta.getTransacoes().size() > 0) {
                File file = new File("documentos/extratos/");
                File[] arquivos = file.listFiles();
                for (File f : arquivos) {
                    if (!f.getName().equals(conta.getNome())) {
                        f.delete();
                    }
                }
            }
        }
    }
    public static void regravaExtrato(){

    }

    public String mostraData() {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String data = ldt.format(dtf);
        return data;
    }
}
