package pessoa;

public class Vendedor extends Empregado{

    private double valorVendas;
    private double comissao;

    public Vendedor(String nome, String endereco, String telefone, int codigoSetor, int salarioBase, double imposto, double valorVendas, double comissao) {
        super(nome, endereco, telefone, codigoSetor, salarioBase, imposto);
        this.valorVendas = valorVendas;
        this.comissao = comissao;
    }

    public double getValorVendas() {
        return valorVendas;
    }

    public double getComissao() {
        return comissao;
    }

    @Override
    public double calcularSalario(){
        return this.getSalarioBase()-(this.getSalarioBase()*(this.getImposto()/100))+
                (this.getValorVendas()*(this.getComissao()/100));
    }
}
