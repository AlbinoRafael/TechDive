package permissaoidade;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class PermissaoIdade {

    public static void main(String[] args) {
        boolean continua;
        do {
            continua = false;
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("\nDigite sua data de nascimento(ex: 01/01/1990): ");
                String dataNascimento = sc.nextLine();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataNasc = LocalDate.parse(dataNascimento, dtf);
                int idade = Period.between(dataNasc, LocalDate.now()).getYears();
                //System.out.println("idade: "+idade);

                if (idade > 18) {
                    System.out.println("Você possui " + idade + " anos, e pode acessar o sistema!");
                } else {
                    System.err.println("Você possui " + idade + " anos, e não pode acessar o sistema!");
                }
            } catch (DateTimeParseException e) {
                continua = true;
                System.err.println("Você inseriu uma data incompatível, siga o exemplo: 01/01/1990\nTente novamente!\n");
            }
        } while (continua);
    }
}
