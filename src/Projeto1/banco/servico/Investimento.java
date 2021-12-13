package banco.servico;

public class Investimento {

    private String tipo;
    private double valorInvestimento;

    public Investimento(String tipo, double valorInvestimento){
        this.tipo = tipo;
        this.valorInvestimento = valorInvestimento;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValorInvestimento() {
        return valorInvestimento;
    }

    public String toString(){
        return "Tipo de investimento: "+this.getTipo()+"\nValor investido: R$ "+this.getValorInvestimento();
    }
}
