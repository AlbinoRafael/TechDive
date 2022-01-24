package hotel.agenda;

import hotel.EnumTipoQuarto;
import hotel.Hospede;
import hotel.Hotel;
import hotel.Quarto;
import hotel.util.Listar;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Reserva {

    private LocalDate dataAgendamento;
    private LocalDate dataFimAgendamento;
    private Hospede hospede;
    private Quarto quarto;
    private int valorReserva;
    private int diasReserva;

    public Reserva(Hospede hospede, Quarto quarto) {
        this.hospede = hospede;
        this.quarto = quarto;
    }
    public Reserva(Hospede hospede, Quarto quarto, String dataInicio, String dataFinal){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataAgendamento = LocalDate.parse(dataInicio, dtf);
        this.dataFimAgendamento = LocalDate.parse(dataFinal, dtf);

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

    public int getValorReserva() {
        return valorReserva;
    }

    private void setValorReserva() {
        this.valorReserva = valorReserva();
    }

    public int getDiasReserva() {
        return diasReserva;
    }

    private void setDiasReserva() {
        this.diasReserva = diasReserva();
    }

    private int diasReserva(){
        return Period.between(dataAgendamento,dataFimAgendamento).getDays();
    }
    private int valorReserva(){
        return this.diasReserva()*this.getQuarto().getValorDiaria();
    }
    public void simulaReserva(String dataInicioReserva,String dataFimReserva){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate inicioAltaTemporada = LocalDate.parse("01-10-" + LocalDate.now().getYear(), dtf);
        LocalDate fimAltaTemporada = LocalDate.parse("31-03-" + LocalDate.now().plusYears(1).getYear(), dtf);

        this.dataAgendamento = LocalDate.parse(dataInicioReserva,dtf);
        this.dataFimAgendamento = LocalDate.parse(dataFimReserva,dtf);
        if (this.getDataAgendamento().isAfter(inicioAltaTemporada) && this.getDataAgendamento().isBefore(fimAltaTemporada)) {
            setDiasReserva();
            if (this.getQuarto().getTipoQuarto().equals(EnumTipoQuarto.SIMPLES)) {
                this.getQuarto().setValorDiaria(140);
            } else if (this.getQuarto().getTipoQuarto().equals(EnumTipoQuarto.LUXO)) {
                this.getQuarto().setValorDiaria(400);
            }
        } else {
            setDiasReserva();
            if (this.getQuarto().getTipoQuarto().equals(EnumTipoQuarto.SIMPLES)) {
                this.getQuarto().setValorDiaria(90);
            } else if (this.getQuarto().getTipoQuarto().equals(EnumTipoQuarto.LUXO)) {
                this.getQuarto().setValorDiaria(150);
            }
        }
        setValorReserva();
        System.out.println("\nSimulação de Reserva\n");

        System.out.println("Data início: "+dtf.format(this.getDataAgendamento()));
        System.out.println("Data fim: "+dtf.format(this.getDataFimAgendamento()));
        System.out.println("Dias de estadia: "+this.getDiasReserva());
        System.out.println("Valor total da Reserva: R$"+this.getValorReserva());
        System.out.println("\n");
    }

    @Override
    public String toString() {
        return "hospede: " + hospede.getNome() + " " + hospede.getSobrenome() +
                ", quarto: " + quarto.getNumeroQuarto();
    }
}
