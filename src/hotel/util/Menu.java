package hotel.util;

import hotel.Hospede;
import hotel.Hotel;
import hotel.agenda.Reserva;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {

    public static void menuPrincipal() {
        boolean continua;
        do {
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
            int opcaoPrincipal = sc.nextInt();
            continua = false;
            switch (opcaoPrincipal) {
                case 1:
                    menuReservas();
                    continua = true;
                    break;
                case 2:
                    menuHospedes();
                    continua = true;
                    break;
                case 3:
                    menuQuartos();
                    continua = true;
                    break;
                case 0:
                    break;
            }

        } while (continua);
    }


    public static void menuReservas() {
        System.out.println("\n=========================================");
        System.out.println("|               Reservas                |");
        System.out.println("=========================================");
        System.out.println("| 1 - Fazer reserva                     |");
        System.out.println("| 2 - Cancelar reserva                  |");
        System.out.println("| 3 - Simular reserva                   |");
        System.out.println("| 4 - Listar reservas                   |");
        System.out.println("| 0 - Sair                              |");
        System.out.println("=========================================");
        System.out.print("Digite a opção desejada: ");

        Scanner sc = new Scanner(System.in);
        int opcaoReservas = sc.nextInt();
        switch (opcaoReservas) {
            case 1:
                sc.nextLine();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                boolean continua;
                do {
                    continua = false;
                    try {
                        System.out.println("Selecione abaixo o hóspede e o quarto desejados: ");
                        Reserva reserva = new Reserva(Listar.escolheQuarto(Hotel.getQuartos()));
                        System.out.println("Você pode agendar um quarto a partir de " + dtf.format(LocalDate.now().plusDays(61)));
                        System.out.print("Digite a data para reserva(ex: 01-01-2022): ");
                        String dataReserva = sc.nextLine();
                        System.out.print("Digite a data para o fim da reserva(ex: 01-01-2022): ");
                        String dataFimReserva = sc.nextLine();
                        if (dataReserva.length() == 10 && dataFimReserva.length() == 10) {
                            reserva.agendarReserva(dataReserva, dataFimReserva);
                        } else {
                            System.err.println("A data que você inseriu é inválida! Siga o exemplo(01-01-2022)!");
                            continua = true;
                        }
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        continua = true;
                    }
                } while (continua);
                break;
            case 2:

                break;
            case 3:
                sc.nextLine();
                System.out.print("Digite a data para a reserva (ex: 01-01-2022): ");
                String dataAgenda = sc.nextLine();
                System.out.print("Digite a data para o fim da reserva (ex: 01-01-2022):");
                String dataFimAgenda = sc.nextLine();
                Reserva reserva = new Reserva(Listar.escolheQuarto(Hotel.getQuartos()));
                reserva.simulaReserva(dataAgenda, dataFimAgenda);
                break;
            case 4:
                dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                for (Hospede h : Hotel.getHospedes()) {
                    for (Reserva r : h.getReservas()) {
                        System.out.println(r.toString());
                        r.simulaReserva(dtf.format(r.getDataAgendamento()), dtf.format(r.getDataFimAgendamento()));
                    }
                }
                break;
            case 0:
                break;
        }
    }

    public static void menuHospedes() {
        System.out.println("\n=========================================");
        System.out.println("|               Hóspedes                |");
        System.out.println("=========================================");
        System.out.println("| 1 - Cadastrar hóspede                 |");
        System.out.println("| 2 - Remover hóspede                   |");
        System.out.println("| 3 - Listar hóspedes cadastrados       |");
        System.out.println("| 0 - Sair                              |");
        System.out.println("=========================================");
        System.out.print("Digite a opção desejada: ");

        Scanner sc = new Scanner(System.in);
        int opcaoHospedes = sc.nextInt();
        switch (opcaoHospedes) {
            case 1:
                sc.nextLine();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                boolean continua;
                do {
                    continua = false;
                    try {
                        System.out.print("Digite o nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Digite o sobrenome: ");
                        String sobrenome = sc.nextLine();
                        System.out.print("Digite o número de identificação(RG ou CPF): ");
                        String documentoIdentificacao = sc.nextLine();
                        System.out.print("Digite a data de nascimento (ex: 01-01-1990): ");
                        String dataNascimento = sc.nextLine();
                        Hospede hospede = new Hospede(nome, sobrenome, documentoIdentificacao, dataNascimento);
                        Hotel.adicionaHospede(hospede);
                    } catch (NullPointerException e) {
                        continua = true;
                    }
                } while (continua);
                break;
            case 2:
                System.out.println("Escolha o hóspede para ser removido: ");
                Hospede hospede = Listar.escolheHospede(Hotel.getHospedes());
                try {
                    if (hospede.getReservas().size() == 0) {
                        for (Hospede h : Hotel.getHospedes()) {
                            if (hospede.getDocumentoIdentificacao().equals(h.getDocumentoIdentificacao())) {
                                Hotel.removeHospede(hospede);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                System.out.println(Listar.listaTodosHospedes());
                break;
            case 0:
                break;
        }
    }

    public static void menuQuartos() {
        System.out.println("\n=========================================");
        System.out.println("|               Quartos                 |");
        System.out.println("=========================================");
        System.out.println("| 1 - Listar todos os quartos           |");
        System.out.println("| 2 - Listar quartos disponíveis        |");
        System.out.println("| 3 - Listar quartos ocupados           |");
        System.out.println("| 0 - Sair                              |");
        System.out.println("=========================================");
        System.out.print("Digite a opção desejada: ");

        Scanner sc = new Scanner(System.in);
        int opcaoQuartos = sc.nextInt();
        switch (opcaoQuartos) {
            case 1:
                System.out.println(Listar.listaQuartos());
                break;
            case 2:
                //System.out.println(Listar.listaQuartosDisponiveis());
                break;
            case 3:
                //System.out.println(Listar.listaQuartosOcupados());
                break;
            case 0:
                break;
        }
    }
}
