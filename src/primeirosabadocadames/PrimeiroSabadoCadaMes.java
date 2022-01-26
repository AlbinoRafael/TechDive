package primeirosabadocadames;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class PrimeiroSabadoCadaMes {

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        TemporalAdjuster ajustadorProxSabado = TemporalAdjusters.next(DayOfWeek.SATURDAY);
        LocalDate ultimoDia = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        for (int i = LocalDate.now().getMonthValue() + 1; i <= 12; i++) {
            LocalDate primeiroSabado = ultimoDia.with(ajustadorProxSabado);
            String primeiroSabadoFormatado = primeiroSabado.format(dtf);
            if (primeiroSabado.getDayOfMonth() == 1 || primeiroSabado.getDayOfMonth() == 2 || primeiroSabado.getDayOfMonth() == 3 ||
                    primeiroSabado.getDayOfMonth() == 4 || primeiroSabado.getDayOfMonth() == 5 || primeiroSabado.getDayOfMonth() == 6
                    || primeiroSabado.getDayOfMonth() == 7) {
                System.out.println("Primeiro sabado do mes " + i + " - " + primeiroSabadoFormatado);
                ultimoDia = ultimoDia.plusMonths(1);
            } else {
                i--;
                ultimoDia = ultimoDia.with(primeiroSabado);
            }
        }
    }
}
