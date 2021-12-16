package main;

import animal.Cachorro;
import animal.Cavalo;
import animal.Preguica;
import veterinario.Veterinario;

class Principal {

    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro("Rex", 2);
        Cavalo cavalo = new Cavalo("Pé-de-Pano", 3);
        Preguica preguica = new Preguica("Soneca", 1);

        Veterinario veterinario = new Veterinario();

        veterinario.examinar(cachorro);
        veterinario.examinar(cavalo);
        veterinario.examinar(preguica);

    }
}
