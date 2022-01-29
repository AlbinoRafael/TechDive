package bancotechdive.banco.servico;

import bancotechdive.banco.conta.Conta;
import bancotechdive.banco.conta.ContaInvestimento;

import java.util.List;

public class Relatorio {

    public static String listarContas(String nome, List<Conta> contas) {
        String retorno = "";
        for (Conta conta : contas) {
            if (conta.getClass().getSimpleName().equals(nome)) {
                retorno += conta + "\n";
            }
        }
        return retorno;
    }

    public static String listarTodasContas(List<Conta> contas) {
        String retorno = "\n====================================\n" +
                            "--------- Lista de Contas ----------" +
                        "\n====================================\n\n";
        for (Conta conta : contas) {
            retorno += conta + "\n";
        }
        return retorno;
    }

    public static String listarContasSaldoNegativo(List<Conta> contas) {
        String retorno = "Não há documentos.contas negativadas!";
        for (Conta conta : contas) {
            if (conta.getSaldo() < 0) {
                retorno = "\n=====================================\n" +
                        "----- Contas com Saldo Negativo -----" +
                        "\n=====================================\n\n";
                retorno += conta + "\n";
            }
        }
        return retorno;
    }

    public static String totalValorInvestido(Conta conta) {
        if (conta != null) {
            ContaInvestimento ci = (ContaInvestimento) conta;
            String retorno = "\n====================================\n" +
                    "------- Total valor investido ------" +
                    "\n====================================\n\n"+
                    "CPF: "+conta.getCpf()+"\n"+
                    "Nome: "+conta.getNome()+"\n"+
                    "Total investido: R$ ";

            retorno += String.format("%.2f",ci.getTotalInvestido());
            return retorno;
        }
        return null;
    }

    public static String todasTransacoesUnicoCliente(Conta conta) {
        String retorno = "";
        if (!conta.getTransacoes().isEmpty()) {
            retorno = "\n====================================\n" +
                    "------- Todas as transações --------" +
                    "\n====================================\n" +
                    "\nNome: " + conta + "\n\n";
            for (Transacao transacao : conta.getTransacoes()) {
                retorno += transacao + "\n";
            }
        }else{
            retorno= "Ainda não realizou nenhuma transação!";
        }
        return retorno;
    }

    public static Conta setaValorContaInvestimento(Conta conta, List<Conta>lista){
        Conta conta1 = (ContaInvestimento)conta;
        for(Conta c:lista){
            if(conta.getCpf().equals(c.getCpf())&&conta.getNome().equals(c.getNome())){
                if(!conta.getTransacoes().isEmpty()) {
                    conta1 = c;
                }
            }
        }
        return conta1;
    }

}
