package listasegundasdeummes;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ListaSegundasDeUmMes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean repete;
        do {
            repete = false;
            try {
                System.out.println("Listando todas as segundas-feiras de um mês");
                System.out.print("Digite o mês: ");
                int mes = sc.nextInt();
                System.out.print("Digite o ano: ");
                int ano = sc.nextInt();
                YearMonth anoMes = YearMonth.of(ano, mes);
                int contaSegunda = 1;
                LocalDate date = anoMes.atDay(1).with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
                String segundaFeira;
                for (int i = contaSegunda; i < contaSegunda + 1; i++) {
                    if (date.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
                        if (date.getMonthValue() == mes) {
                            segundaFeira = date.format(dtf);
                            System.out.println(segundaFeira);
                            date = date.plusDays(7);
                            contaSegunda++;
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.err.println("Insira apenas números!");
                repete = true;
                sc.nextLine();
            }
        } while (repete);
    }
}
