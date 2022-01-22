package hotel;

import hotel.agenda.Reserva;
import hotel.util.Listar;
import hotel.util.Menu;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Hotel {

    private static List<Quarto> quartos = new ArrayList<>();
    private static List<Hospede> hospedes = new ArrayList<>();
    public static List<Reserva> reservas = new ArrayList<>();

    static {
        Quarto quarto101 = new Quarto(101, true, EnumTipoQuarto.SIMPLES);
        Quarto quarto102 = new Quarto(102, true, EnumTipoQuarto.SIMPLES);
        Quarto quarto103 = new Quarto(103, true, EnumTipoQuarto.SIMPLES);
        Quarto quarto104 = new Quarto(104, true, EnumTipoQuarto.SIMPLES);
        Quarto quarto105 = new Quarto(105, true, EnumTipoQuarto.SIMPLES);
        Quarto quarto201 = new Quarto(201, true, EnumTipoQuarto.LUXO);
        Quarto quarto202 = new Quarto(202, true, EnumTipoQuarto.LUXO);
        Quarto quarto203 = new Quarto(203, true, EnumTipoQuarto.LUXO);
        Quarto quarto204 = new Quarto(204, true, EnumTipoQuarto.LUXO);
        Quarto quarto205 = new Quarto(205, true, EnumTipoQuarto.LUXO);

        adicionaQuarto(quarto101);
        adicionaQuarto(quarto102);
        adicionaQuarto(quarto103);
        adicionaQuarto(quarto104);
        adicionaQuarto(quarto105);
        adicionaQuarto(quarto201);
        adicionaQuarto(quarto202);
        adicionaQuarto(quarto203);
        adicionaQuarto(quarto204);
        adicionaQuarto(quarto205);
    }

    static {
        Hospede hospede1 = new Hospede("Joao", "da Silva", "12312312345", "02-04-1985");
        Hospede hospede2 = new Hospede("Pedro", "de Souza", "32132132154", "22-01-1990");
        Hospede hospede3 = new Hospede("Maria", "Moreira", "12332145678", "16-04-1954");
        Hospede hospede4 = new Hospede("Marcos", "Pereira", "65465465412", "30-09-1978");
        Hospede hospede5 = new Hospede("Joana", "da Fonseca", "14514514589", "15-11-1960");

        adicionaHospede(hospede1);
        adicionaHospede(hospede2);
        adicionaHospede(hospede3);
        adicionaHospede(hospede4);
        adicionaHospede(hospede5);
    }

    public static void main(String[] args) {


    }

    public static List<Quarto> getQuartos() {
        return Collections.unmodifiableList(quartos);
    }

    public static List<Hospede> getHospedes() {
        return Collections.unmodifiableList(hospedes);
    }

    public static List<Reserva> getReservas() {
        return Collections.unmodifiableList(reservas);
    }

    private static void adicionaQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public static void adicionaHospede(Hospede hospede) {
        hospedes.add(hospede);
    }

    public static void removeHospede(Hospede hospede) {
        hospedes.remove(hospede);
    }

    public static void registraReserva(Reserva reserva) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate inicioAltaTemporada = LocalDate.parse("01-10-" + LocalDate.now().getYear(), dtf);
        LocalDate fimAltaTemporada = LocalDate.parse("31-03-" + LocalDate.now().getYear() + 1, dtf);
        for (Quarto quarto : quartos) {
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
                quarto.setEstaDisponivel(false);
                reservas.add(reserva);
            }
        }
    }

    public static void cancelaReserva(Reserva reserva) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumeroQuarto() == reserva.getQuarto().getNumeroQuarto()) {
                quarto.setEstaDisponivel(true);
                reservas.remove(reserva);
            }
        }

    }

}
