package hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Quarto {

    private int numeroQuarto;
    private boolean estaDisponivel;
    private int valorDiaria;
    private EnumTipoQuarto tipoQuarto;

    public Quarto(int numeroQuarto, boolean estaDisponivel, EnumTipoQuarto tipoQuarto) {
        this.numeroQuarto = numeroQuarto;
        this.estaDisponivel = estaDisponivel;
        this.tipoQuarto = tipoQuarto;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public boolean isEstaDisponivel() {
        return estaDisponivel;
    }

    public void setEstaDisponivel(boolean estaDisponivel) {
        this.estaDisponivel = estaDisponivel;
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

    @Override
    public String toString() {
        return "quarto Nº: " + numeroQuarto +
                ", tipo do quarto: " + tipoQuarto.getTipo();
    }
}
