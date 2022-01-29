package bancotechdive.banco.conta;

import bancotechdive.banco.servico.Rendimentos;

public class ContaPoupanca extends Conta implements Rendimentos {

    public ContaPoupanca(){
        super();
    }

    public ContaPoupanca(String nome, String cpf, double rendaMensal){
        super();
        super.setNome(nome);
        super.setCpf(cpf);
        super.setRendaMensal(rendaMensal);
    }

    public double simulaRendimentos(double valorSimulacao, int meses, double rentabilidadeAnual) {
        double rendimentoMes = (rentabilidadeAnual/12)/100;
        double valorSimulado = valorSimulacao;
        for (int i = 0; i < meses; i++) {
            valorSimulado += valorSimulado * rendimentoMes;
        }
        return valorSimulado;
    }

}
