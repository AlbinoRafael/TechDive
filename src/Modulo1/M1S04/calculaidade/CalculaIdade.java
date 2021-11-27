package calculaidade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CalculaIdade {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite sua data de aniversário(Ex: 01/01/2000): ");
		String dataNascimento = sc.next();
		LocalDate aniversario = null;

		boolean ehDataValida;
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy").withResolverStyle(ResolverStyle.STRICT);
			aniversario = LocalDate.parse(dataNascimento, dtf);
			ehDataValida = true;
		} catch (DateTimeParseException e) {
			ehDataValida = false;
		}
		if (ehDataValida) {
			int idade = Period.between(aniversario, LocalDate.now()).getYears();
			System.out.print(idade < 18 ? "\nVocê tem " + idade + " anos. Você é menor de idade!!" :
					"\nVocê tem " + idade + " anos. Você é maior de idade!!");
		}else{
			System.out.println("Digite uma data válida!!");
		}
	}
}
