package ehsexta13;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EhSextaFeira13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean repete;
        do {
            repete = false;
            try {

                System.out.println("Verificando se uma data é sexta-feira 13");
                System.out.print("Digite uma data: ");
                String data = sc.nextLine();
                LocalDate dataConvertida = LocalDate.parse(data, dtf);
                TemporalAdjuster sextaFeiraTreze = TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY);

                LocalDate sexta13 = dataConvertida.with(sextaFeiraTreze);

                if (sexta13.getDayOfMonth() == 13 && sexta13.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                    System.out.print("A data inserida é uma sexta-feira 13\n");
                } else {
                    repete = true;
                    System.out.println("A data inserida não é uma sexta-feira 13");
                    System.err.println("Tente novamente!\n");
                }
            }catch (InputMismatchException e){
                System.err.println("Apenas NUMEROS! siga o exemplo: 01/01/2022");
            }catch(DateTimeParseException e){
                System.err.println("A data inserida é inválida! Tente novamente!\n");
                repete = true;
            }
        }while(repete);

    }
}
