package pessoa;

public class Operario extends Empregado{

    private double valorProducao;
    private double comissao;

    public Operario(String nome, String endereco, String telefone, int codigoSetor, int salarioBase, double imposto, double valorProducao, double comissao) {
        super(nome, endereco, telefone, codigoSetor, salarioBase, imposto);
        this.valorProducao = valorProducao;
        this.comissao = comissao;
    }

    public double getValorProducao() {
        return valorProducao;
    }

    public double getComissao() {
        return comissao;
    }

    @Override
    public double calcularSalario(){
        return this.getSalarioBase()-(this.getSalarioBase()*(this.getImposto()/100))+
                (this.getValorProducao()*(this.getComissao()/100));
    }
}
