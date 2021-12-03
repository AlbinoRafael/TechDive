package M1S05.classe1;

import M1S05.classe2.Classe2;

public class Classe1 {

    public static void main(String[] args) {
        //usando objeto
        Classe2 c2 = new Classe2();
        c2.mensagem();
        //usando metodo estatico
        Classe2.mensagemStatic();
    }
}
