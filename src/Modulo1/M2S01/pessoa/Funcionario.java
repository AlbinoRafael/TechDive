package pessoa;

public class Funcionario extends Pessoa{

    private double valorCredito;
    private double valorDivida;

    public Funcionario(String nome, String endereco, String telefone, double valorCredito, double valorDivida) {
        super(nome, endereco, telefone);
        this.valorCredito = valorCredito;
        this.valorDivida = valorDivida;
    }

    public double getValorCredito() {
        return valorCredito;
    }

    public double getValorDivida() {
        return valorDivida;
    }

    public double obterSaldo(){
        return this.getValorCredito() - this.getValorDivida();
    }
}
