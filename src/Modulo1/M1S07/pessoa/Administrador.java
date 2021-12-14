package pessoa;

public class Administrador extends Empregado{

    private double ajudaDeCusto;

    public Administrador(String nome, String endereco, String telefone, int codigoSetor, int salarioBase, double imposto,double ajudaDeCusto) {
        super(nome, endereco, telefone, codigoSetor, salarioBase, imposto);
        this.ajudaDeCusto = ajudaDeCusto;
    }

    public double getAjudaDeCusto() {
        return ajudaDeCusto;
    }
    @Override
    public double calcularSalario(){
        return (this.getSalarioBase()-(this.getSalarioBase()*(this.getImposto()/100)))+this.getAjudaDeCusto();
    }
}
