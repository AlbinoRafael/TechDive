package bancotechdive.banco.conta;

import bancotechdive.banco.servico.Investimento;
import bancotechdive.banco.servico.Rendimentos;
import bancotechdive.banco.servico.Transacao;

import java.util.ArrayList;
import java.util.List;

public class ContaInvestimento extends Conta implements Rendimentos {

    private List<Investimento> investimentos = new ArrayList<>();
    private double totalInvestido;
    private double saldoTotal;

    public ContaInvestimento() {
        super();
    }

    public ContaInvestimento(String nome, String cpf, double rendaMensal) {
        super();
        super.setNome(nome);
        super.setCpf(cpf);
        super.setRendaMensal(rendaMensal);
        this.setSaldoTotal();
        super.setTipo("CI");
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal() {
        this.saldoTotal = this.getSaldo() + this.getTotalInvestido();
    }

    public double getTotalInvestido() {
        return totalInvestido;
    }

    public void setTotalInvestido(double totalInvestido) {
        this.totalInvestido = totalInvestido;
    }

    public List<Investimento> getInvestimentos() {
        return investimentos;
    }

    public double simulaRendimentos(double valorSimulacao, int meses, double rentabilidadeAnual) {
        final double selic = 9.25;
        double rendimentoAnual = (selic * rentabilidadeAnual) / 100;
        double valorSimulado = valorSimulacao;
        for (int i = 0; i < meses; i++) {
            valorSimulado += valorSimulado * rendimentoAnual;
        }
        return valorSimulado;
    }

    public void investir(String tipo, double valorInvestimento, double rentabilidadeAnual) {
        if (this.getSaldo() >= valorInvestimento) {
            Transacao transacao = new Transacao(this, valorInvestimento);
            transacao.setTipo("investimento");
            Investimento investimento = new Investimento(tipo, valorInvestimento);
            this.getInvestimentos().add(investimento);
            this.getTransacoes().add(transacao);
            this.setSaldo(this.getSaldo() - valorInvestimento);
            final double selic = 9.25;
            double rendimentoAnual = (selic * rentabilidadeAnual) / 100;
            double valorInvestido = valorInvestimento;
            for (int i = 0; i < 12; i++) {
                valorInvestido += (valorInvestido * rendimentoAnual);
            }
            this.setTotalInvestido(this.getTotalInvestido() + valorInvestido);
        }
    }
}
