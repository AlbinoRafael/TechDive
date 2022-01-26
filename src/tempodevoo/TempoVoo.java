package tempodevoo;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TempoVoo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean repete;
        do {
            repete = false;
            try {
                System.out.print("Digite a data de saída do voo(ex: 01/01/2022): ");
                String dataSaida = sc.nextLine();
                LocalDate dtSaida = LocalDate.parse(dataSaida, dtf);
                System.out.println("Digite o horario de saída, horas e depois minutos: ");
                System.out.print("Horas: ");
                int horasSaida = sc.nextInt();
                System.out.print("Minutos: ");
                int minutosSaida = sc.nextInt();
                LocalTime horarioSaida = LocalTime.of(horasSaida, minutosSaida);
                LocalDateTime dataSaidaVoo = LocalDateTime.of(dtSaida, horarioSaida);

                sc.nextLine();

                System.out.print("Digite a data de chegada do voo(ex: 01/01/2022): ");
                String dataChegada = sc.nextLine();
                LocalDate dtChegada = LocalDate.parse(dataChegada, dtf);
                System.out.println("Digite o horario de chegada, horas e depois minutos: ");
                System.out.print("Horas: ");
                int horasChegada = sc.nextInt();
                System.out.print("Minutos: ");
                int minutosChegada = sc.nextInt();
                LocalTime horarioChegada = LocalTime.of(horasChegada, minutosChegada);
                LocalDateTime dataChegadaVoo = LocalDateTime.of(dtChegada, horarioChegada);

                ZoneId fusoSaoPaulo = ZoneId.of("America/Sao_Paulo");
                ZoneId fusoBerlin = ZoneId.of("Europe/Berlin");

                ZonedDateTime saidaDeSaoPaulo = ZonedDateTime.of(dataSaidaVoo, fusoSaoPaulo);
                ZonedDateTime chegadaEmBerlin = ZonedDateTime.of(dataChegadaVoo, fusoBerlin);

                Duration duracaoVoo = Duration.between(saidaDeSaoPaulo, chegadaEmBerlin);
                System.out.println("Duração do voo: " + duracaoVoo.toHours() + " horas.");
            }catch (DateTimeParseException e) {
                repete = true;
                System.err.println("A data que você inseriu é inválida! tente novamente!");
            }catch(InputMismatchException e){
                repete = true;
                System.err.println("Insira apenas números!");
            }
        }while(repete);
    }
}
