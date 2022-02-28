package hotel.agenda;

import hotel.EnumTipoQuarto;
import hotel.Hospede;
import hotel.Hotel;
import hotel.Quarto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {

    private LocalDate dataAgendamento;
    private LocalDate dataFimAgendamento;
    private Hospede hospede;
    private Quarto quarto;

    public Reserva(Hospede hospede, Quarto quarto) {
        this.hospede = hospede;
        this.quarto = quarto;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public LocalDate getDataFimAgendamento() {
        return dataFimAgendamento;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public void agendarReserva(String dataAgendamento, int diasReserva) {
        LocalDate dataAgenda = LocalDate.parse(dataAgendamento);
        if (dataAgenda.isBefore(LocalDate.now().plusDays(60))) {
            if (quarto.estaDisponivel(dataAgenda, diasReserva)) {
                this.dataAgendamento = dataAgenda;
                this.dataFimAgendamento = dataAgenda.plusDays(diasReserva);
            } else {
                throw new IllegalArgumentException("O quarto não está disponível para reserva!");
            }
        } else {
            throw new IllegalArgumentException("Você precisa agendar com pelo menos 60 dias de antecedência!");
        }
    }

    public static void registraReserva(Reserva reserva) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate inicioAltaTemporada = LocalDate.parse("01-10-" + LocalDate.now().getYear(), dtf);
        LocalDate fimAltaTemporada = LocalDate.parse("31-03-" + LocalDate.now().getYear() + 1, dtf);
        for (Quarto quarto : Hotel.getQuartos()) {
            if (quarto.getNumeroQuarto() == reserva.getQuarto().getNumeroQuarto()) {
                if (reserva.getDataAgendamento().isAfter(fimAltaTemporada) && reserva.getDataAgendamento().isBefore(inicioAltaTemporada)) {
                    if (reserva.getQuarto().getTipoQuarto().equals(EnumTipoQuarto.SIMPLES)) {
                        reserva.getQuarto().setValorDiaria(140);
                    } else if (reserva.getQuarto().getTipoQuarto().equals(EnumTipoQuarto.LUXO)) {
                        reserva.getQuarto().setValorDiaria(400);
                    }
                } else {
                    if (reserva.getQuarto().getTipoQuarto().equals(EnumTipoQuarto.SIMPLES)) {
                        reserva.getQuarto().setValorDiaria(90);
                    } else if (reserva.getQuarto().getTipoQuarto().equals(EnumTipoQuarto.LUXO)) {
                        reserva.getQuarto().setValorDiaria(150);
                    }
                }
                Hotel.getReservas().add(reserva);
            }
        }
    }

    @Override
    public String toString() {
        return "hospede " + hospede.getNome() + " " + hospede.getSobrenome() +
                ", quarto " + quarto.getNumeroQuarto();
    }
}
