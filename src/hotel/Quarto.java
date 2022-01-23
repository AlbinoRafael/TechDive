package hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Quarto {

    private int numeroQuarto;
    private boolean estaDisponivel;
    private int valorDiaria;
    private LocalDate dataReserva;
    private EnumTipoQuarto tipoQuarto;

    public Quarto(int numeroQuarto, boolean estaDisponivel, EnumTipoQuarto tipoQuarto) {
        this.numeroQuarto = numeroQuarto;
        this.estaDisponivel = estaDisponivel;
        this.tipoQuarto = tipoQuarto;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    private LocalDate getDataReserva(){
        return this.dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva){
        this.dataReserva = dataReserva;
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

    public void setTipoQuarto(EnumTipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public String retornaDataReserva(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dataReservada = dtf.format(this.getDataReserva());
        return dataReservada;
    }

    @Override
    public String toString() {
        return "quarto Nº: " + numeroQuarto +
                ", tipo do quarto: " + tipoQuarto.getTipo();
    }
}
