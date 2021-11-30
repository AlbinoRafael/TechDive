package estaticos;

import java.util.Calendar;
import java.util.Random;


public class Estaticos {

    public static void main(String[] args) {

        System.out.println("nome do SO: "+System.getProperty("os.name"));

        System.out.println("data atual: "+Calendar.getInstance().getTime());

        System.out.println("numero aleatório: "+Math.random());

    }
}
