package hotel.util;

import hotel.Hotel;
import hotel.agenda.Reserva;

import java.util.Scanner;

public class Menu {

    public static void menuPrincipal() {
        System.out.println("=========================================");
        System.out.println("|           Hotel Tech Dive             |");
        System.out.println("=========================================");
        System.out.println("| 1 - Reservas                          |");
        System.out.println("| 2 - Hóspedes                          |");
        System.out.println("| 3 - Quartos                           |");
        System.out.println("| 0 - Sair                              |");
        System.out.println("=========================================");
        System.out.print("Digite a opção desejada: ");

        Scanner sc = new Scanner(System.in);
        Menu.menuPrincipal();
        boolean continua = false;
        do {
            int opcaoPrincipal = sc.nextInt();
            switch (opcaoPrincipal) {
                case 1:
                    menuReservas();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    break;
            }

        } while (continua);
    }


    public static void menuReservas() {
        System.out.println("=========================================");
        System.out.println("|               Reservas                |");
        System.out.println("=========================================");
        System.out.println("| 1 - Fazer reserva                     |");
        System.out.println("| 2 - Cancelar reserva                  |");
        System.out.println("| 0 - Sair                              |");
        System.out.println("=========================================");
        System.out.print("Digite a opção desejada: ");

        Scanner sc = new Scanner(System.in);
        Menu.menuReservas();
        int opcaoReservas = sc.nextInt();
        switch (opcaoReservas) {
            case 1:
                Reserva reserva = new Reserva(Listar.escolheHospede(Hotel.getHospedes()), Listar.escolheQuarto(Hotel.getQuartos()));
                System.out.print("Digite a data para reserva(ex: 01-01-2022): ");
                String dataReserva = sc.nextLine();
                System.out.print("Quantos dias pretende reservar?: ");
                int diasReserva = sc.nextInt();
                reserva.agendarReserva(dataReserva, diasReserva);
                break;
            case 2:
                Reserva reservaParaCancelar = Listar.escolheReserva(Hotel.getReservas());
                if(reservaParaCancelar!=null){
                    Hotel.cancelaReserva(reservaParaCancelar);
                }
                break;
            case 0:
                break;
        }
    }

    public static void menuHospedes() {
        System.out.println("=========================================");
        System.out.println("|               Hóspedes                |");
        System.out.println("=========================================");
        System.out.println("| 1 - Cadastrar hóspede                 |");
        System.out.println("| 2 - Remover hóspede                   |");
        System.out.println("| 3 - Listar hóspedes cadastrados       |");
        System.out.println("| 0 - Sair                              |");
        System.out.println("=========================================");
        System.out.print("Digite a opção desejada: ");
    }

    public static void menuQuartos() {
        System.out.println("=========================================");
        System.out.println("|               Quartos                 |");
        System.out.println("=========================================");
        System.out.println("| 1 - Listar todos os quartos           |");
        System.out.println("| 2 - Listar quartos disponíveis        |");
        System.out.println("| 3 - Listar quartos ocupados           |");
        System.out.println("| 0 - Sair                              |");
        System.out.println("=========================================");
        System.out.print("Digite a opção desejada: ");
    }
}
