package hotel.agenda;

import hotel.Hospede;
import hotel.Quarto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Reserva {

    private LocalDate dataAgendamento;
    private LocalDate dataFimAgendamento;
    private Hospede hospede;
    private Quarto quarto;

    public Reserva(Hospede hospede, Quarto quarto) {
        this.hospede = hospede;
        this.quarto = quarto;
    }

    public void agendarReserva(String dataAgendamento, String dataFimAgendamento) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate dataAgenda = LocalDate.parse(dataAgendamento, dtf);
            LocalDate dataFimAgenda = LocalDate.parse(dataFimAgendamento, dtf);
            if (dataAgenda.isAfter(LocalDate.now().plusDays(60)) && dataFimAgenda.isAfter(dataAgenda)) {
                if (quarto.isEstaDisponivel()) {
                    this.dataAgendamento = dataAgenda;
                    this.dataFimAgendamento = dataFimAgenda;
                }
            } else {
                System.err.println("Você precisa agendar com pelo menos 60 dias de antecedência!");
            }

        } catch (DateTimeParseException e) {
            System.err.println("A data que você inseriu é inválida! siga o exemplo(01-01-2022)!");
        }
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public LocalDate getDataFimAgendamento() {
        return dataFimAgendamento;
    }

    public void setDataFimAgendamento(LocalDate dataFimAgendamento) {
        this.dataFimAgendamento = dataFimAgendamento;
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

    @Override
    public String toString() {
        return "hospede " + hospede.getNome() + " " + hospede.getSobrenome() +
                ", quarto " + quarto.getNumeroQuarto();
    }
}
