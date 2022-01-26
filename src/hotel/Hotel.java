package hotel;

import hotel.agenda.Reserva;
import hotel.util.Menu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hotel {

    private static List<Quarto> quartos = new ArrayList<>();
    private static List<Hospede> hospedes = new ArrayList<>();

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
        Quarto quarto301 = new Quarto(301,true,EnumTipoQuarto.SUPREMA);
        Quarto quarto302 = new Quarto(302,true,EnumTipoQuarto.SUPREMA);
        Quarto quarto303 = new Quarto(303,true,EnumTipoQuarto.SUPREMA);
        Quarto quarto304 = new Quarto(304,true,EnumTipoQuarto.SUPREMA);
        Quarto quarto305 = new Quarto(305,true,EnumTipoQuarto.SUPREMA);

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
        adicionaQuarto(quarto301);
        adicionaQuarto(quarto302);
        adicionaQuarto(quarto303);
        adicionaQuarto(quarto304);
        adicionaQuarto(quarto305);
    }

    static {
        Hospede hospede1 = new Hospede("Joao", "da Silva", "12312312345", "02-04-1985");
        Hospede hospede2 = new Hospede("Pedro", "de Souza", "32132132154", "22-01-1990");
        Hospede hospede3 = new Hospede("Maria", "Moreira", "12332145678", "16-04-1954");
        Hospede hospede4 = new Hospede("Marcos", "Pereira", "65465465412", "30-09-1978");
        Hospede hospede5 = new Hospede("Joana", "da Fonseca", "14514514589", "15-11-1960");
        Hospede hospede6 = new Hospede("Frederico", "de Sá", "98798798765", "09-10-1958");
        Hospede hospede7 = new Hospede("Paulo", "da Costa", "98745632109", "16-12-1965");
        Hospede hospede8 = new Hospede("Mariana", "Oliveira", "14714714790", "30-11-1998");
        Hospede hospede9 = new Hospede("Joaquina", "Cruz", "25825825880", "03-01-1996");
        Hospede hospede10 = new Hospede("Ismael", "dos Santos", "36936936999", "18-07-1986");

        adicionaHospede(hospede1);
        adicionaHospede(hospede2);
        adicionaHospede(hospede3);
        adicionaHospede(hospede4);
        adicionaHospede(hospede5);
        adicionaHospede(hospede6);
        adicionaHospede(hospede7);
        adicionaHospede(hospede8);
        adicionaHospede(hospede9);
        adicionaHospede(hospede10);

        Reserva reserva1 = new Reserva(quartos.get(0), "10-05-2022", "15-05-2022");
        Reserva reserva2 = new Reserva(quartos.get(1), "20-05-2022", "23-05-2022");
        Reserva reserva3 = new Reserva(quartos.get(2), "04-06-2022", "08-06-2022");
        Reserva reserva4 = new Reserva(quartos.get(3), "17-08-2022", "26-08-2022");
        Reserva reserva5 = new Reserva(quartos.get(4), "11-10-2022", "15-10-2022");
        Reserva reserva6 = new Reserva(quartos.get(5), "25-12-2022", "03-01-2023");
        Reserva reserva7 = new Reserva(quartos.get(6), "12-05-2022", "18-05-2022");
        Reserva reserva8 = new Reserva(quartos.get(7), "03-02-2023", "15-02-2023");
        Reserva reserva9 = new Reserva(quartos.get(10), "06-03-2023", "15-03-2023");
        Reserva reserva10 = new Reserva(quartos.get(13), "19-04-2023", "23-04-2023");

        hospede1.adicionaReserva(reserva1);
        hospede2.adicionaReserva(reserva2);
        hospede3.adicionaReserva(reserva3);
        hospede4.adicionaReserva(reserva4);
        hospede5.adicionaReserva(reserva5);
        hospede6.adicionaReserva(reserva6);
        hospede7.adicionaReserva(reserva7);
        hospede8.adicionaReserva(reserva8);
        hospede9.adicionaReserva(reserva9);
        hospede10.adicionaReserva(reserva10);

    }

    public static void main(String[] args) {
        Menu.menuPrincipal();
    }

    public static List<Quarto> getQuartos() {
        return Collections.unmodifiableList(quartos);
    }

    public static List<Hospede> getHospedes() {
        return Collections.unmodifiableList(hospedes);
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

}