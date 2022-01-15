package dados;

import java.util.Random;

public class Dado {

    public Dado(){
    }
    public static int jogarDado(){
        Random random = new Random();
        int valor = random.nextInt(10+1)+1;
        return valor;
    }
}
