package main;

import animal.Cachorro;
import animal.Cavalo;
import animal.Preguica;

public class main {

    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro("Rex", 2);
        Cavalo cavalo = new Cavalo("Pé-de-Pano", 3);
        Preguica preguica = new Preguica("Soneca", 1);

        System.out.println("Animais se movimentando: ");
        cachorro.correr();
        cavalo.correr();
        preguica.subirEmArvore();

        System.out.println("\n\nAnimais emitindo som: ");
        cachorro.emitirSom();
        cavalo.emitirSom();
        preguica.emitirSom();
    }
}
