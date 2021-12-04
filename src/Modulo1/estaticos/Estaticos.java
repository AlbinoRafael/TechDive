package estaticos;

import static java.util.Calendar.getInstance;
import static java.lang.System.getProperty;
import static java.lang.Math.random;


public class Estaticos {

    public static void main(String[] args) {

        System.out.println("Localização do SO: "+getProperty("os.name"));

        System.out.println("data atual: "+getInstance().getTime());

        System.out.printf("Numero aleatorio: %.2f",random()*100);

    }
}
