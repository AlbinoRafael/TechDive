package dados;

import java.util.Random;

public class Dado {

    private Dado(){
    }
    public static int jogarDado(int min, int max){
        Random random = new Random();
        int valor = random.nextInt((max-min)+min);
        return valor;
    }
}
