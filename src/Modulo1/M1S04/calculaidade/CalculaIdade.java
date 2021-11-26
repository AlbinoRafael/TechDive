package calculaidade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CalculaIdade {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite sua data de aniversário(Ex: 01/01/2000): ");
		String dataNascimento = sc.next();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAtual = new Date();
		Date aniversario = null;

		try {
			aniversario = sdf.parse(dataNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		long diferenca = dataAtual.getTime() - aniversario.getTime();

		TimeUnit time = TimeUnit.DAYS;
		long idade = time.convert(diferenca, TimeUnit.MILLISECONDS) / 365;

		if (idade < 18) {
			System.out.print("Você tem " + idade + " anos. Você é menor de idade!!");
		} else {
			System.out.print("Você tem " + idade + " anos. Você é maior de idade!!");
		}

	}

}
