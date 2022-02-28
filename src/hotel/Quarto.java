package hotel;

import hotel.agenda.Reserva;

import java.time.LocalDate;

public class Quarto {

    private int numeroQuarto;
    private int valorDiaria;
    private EnumTipoQuarto tipoQuarto;

    public Quarto(int numeroQuarto, EnumTipoQuarto tipoQuarto) {
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

    public void setTipoQuarto(EnumTipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public boolean estaDisponivel(LocalDate dataInicio, int diasReserva) {
        LocalDate dataFim = dataInicio.plusDays(diasReserva);
        if (!Hotel.getReservas().isEmpty()) {
            for (Reserva r : Hotel.getReservas()) {
                if ((dataInicio.isBefore(r.getDataAgendamento()) && dataFim.isBefore(r.getDataAgendamento()))
                        || dataInicio.isAfter(r.getDataAgendamento()) && dataFim.isAfter(r.getDataFimAgendamento())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "numero do quarto: " + numeroQuarto +
                ", valor da diaria: " + valorDiaria +
                ", tipo do quarto: " + tipoQuarto.getTipo();
    }
}
