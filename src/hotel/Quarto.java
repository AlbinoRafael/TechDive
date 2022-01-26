package hotel;

public class Quarto {

    private int numeroQuarto;
    private int valorDiaria;
    private EnumTipoQuarto tipoQuarto;
    private String historico;

    public Quarto(int numeroQuarto, boolean estaDisponivel, EnumTipoQuarto tipoQuarto) {
        this.numeroQuarto = numeroQuarto;
        this.tipoQuarto = tipoQuarto;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public int getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(int valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public EnumTipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public String getHistorico() {
        return historico;
    }
    public void setHistorico(String historico){
        this.historico = historico;
    }

    @Override
    public String toString() {
        return "quarto Nº: " + numeroQuarto +
                ", tipo do quarto: " + tipoQuarto.getTipo();
    }
}
