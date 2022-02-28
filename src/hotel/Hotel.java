package hotel;

import hotel.agenda.Reserva;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hotel {

    private static List<Quarto> quartos = new ArrayList<>();
    private static List<Hospede> hospedes = new ArrayList<>();
    public static List<Reserva> reservas = new ArrayList<>();

    static {
        Quarto quarto101 = new Quarto(101,  EnumTipoQuarto.SIMPLES);
        Quarto quarto102 = new Quarto(102,  EnumTipoQuarto.SIMPLES);
        Quarto quarto103 = new Quarto(103,  EnumTipoQuarto.SIMPLES);
        Quarto quarto104 = new Quarto(104,  EnumTipoQuarto.SIMPLES);
        Quarto quarto105 = new Quarto(105,  EnumTipoQuarto.SIMPLES);
        Quarto quarto201 = new Quarto(201, EnumTipoQuarto.LUXO);
        Quarto quarto202 = new Quarto(202,  EnumTipoQuarto.LUXO);
        Quarto quarto203 = new Quarto(203, EnumTipoQuarto.LUXO);
        Quarto quarto204 = new Quarto(204, EnumTipoQuarto.LUXO);
        Quarto quarto205 = new Quarto(205,  EnumTipoQuarto.LUXO);

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
        Hospede hospede1 = new Hospede("Joao", "da Silva", "12312312345", "02-04-1985",EnumTipoQuarto.SIMPLES);
        Hospede hospede2 = new Hospede("Pedro", "de Souza", "32132132154", "22-01-1990",EnumTipoQuarto.LUXO);
        Hospede hospede3 = new Hospede("Maria", "Moreira", "12332145678", "16-04-1954",EnumTipoQuarto.SIMPLES);
        Hospede hospede4 = new Hospede("Marcos", "Pereira", "65465465412", "30-09-1978",EnumTipoQuarto.SIMPLES);
        Hospede hospede5 = new Hospede("Joana", "da Fonseca", "14514514589", "15-11-1960",EnumTipoQuarto.LUXO);

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



    public static void cancelaReserva(Reserva reserva) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumeroQuarto() == reserva.getQuarto().getNumeroQuarto()) {
                reservas.remove(reserva);
            }
        }

    }

}
